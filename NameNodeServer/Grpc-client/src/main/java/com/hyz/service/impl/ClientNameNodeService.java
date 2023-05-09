package com.hyz.service.impl;

import com.hyz.dao.document.BasicMetadata;
import com.hyz.dao.document.FolderMetadata;
import com.hyz.dao.entity.BlockMetadata;
import com.hyz.dao.mapper.BlockMetadataMapper;
import com.hyz.dao.repository.BasicMetadataRepository;
import com.hyz.dao.repository.FolderMetadataRepository;
import com.hyz.proto.Client_NameNode;
import com.hyz.proto.NameNodeRPCGrpc;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author HGD
 * @date 2022/8/30 14:29
 */
@GRpcService
public class ClientNameNodeService extends NameNodeRPCGrpc.NameNodeRPCImplBase {
    @Resource
    private BasicMetadataRepository basicMetadataRepository;
    @Resource
    private FolderMetadataRepository folderMetadataRepository;
    @Resource
    private BlockMetadataMapper blockMetadataMapper;

    /**
     * 用户创建文件，Client 传入基础元数据，返回当前路径下的所有文件基础元数据
     *
     * @param request          Client 传入基础元数据
     * @param responseObserver 返回当前路径下的所有文件基础元数据
     */
    @Override
    public void put(Client_NameNode.BasicMetadata request, StreamObserver<Client_NameNode.ListMetaResponse> responseObserver) {
        // 1. 获取文件哈希值
        String fileHash = request.getFileHash();
        // 2. 判断文件是否已经存在
        boolean filePresent = basicMetadataRepository.findById(fileHash).isPresent();

        // 3. 获取路径
        String path = request.getPath();
        // 4. 计算出路径哈希值
        String pathHash = DigestUtils.md5DigestAsHex(path.getBytes());
        // 5. 判断路径是否存在
        boolean folderPresent = folderMetadataRepository.findById(pathHash).isPresent();

        // 预设信息
        String message = "";
        String remotePath = "";

        if (!folderPresent) {
            // 6. 如果路径不存在则创建文件夹
            createFilePath(path, pathHash);
        } else if (filePresent) {
            // 7. 路径存在且有相同文件，则更新预设信息
            message = "文件元数据存储错误";
            remotePath = "文件元数据存储错误";
        }
        if (!filePresent && !folderPresent) {
            // 8. 如果路径存在且没有相同文件，将文件元数据保存
            String fileName = request.getFileName();
            String fileSize = request.getFileSize();
            String fileExtension = request.getFileExtension();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String reviseTime = formatter.format(date);
            basicMetadataRepository.save(new BasicMetadata(
                    fileHash, pathHash, fileName, fileSize, fileExtension, path, reviseTime, null));
        }

        // 9. 返回当前目录下的所有元数据列表
        List<BasicMetadata> basicMetadataList = basicMetadataRepository.findByPathHash(pathHash);
        List<FolderMetadata> folderMetadataList = folderMetadataRepository.findByParentPathHash(pathHash);
        for (FolderMetadata folderMetadata : folderMetadataList) {
            basicMetadataList.add(folderMetadata.metadata());
        }
        // 10. 创建builder，将列表放进去
        Client_NameNode.ListMetaResponse.Builder builder = null;
        for (int i = 0; i < basicMetadataList.size(); i++) {
            builder = Client_NameNode.ListMetaResponse.newBuilder()
                    .setIsSucceed(filePresent)
                    .setErrMessage(message)
                    .setRemotePath(remotePath).setBasicMetadata(i, basicMetadataList.get(i))
                    .setBasicMetadata(i, basicMetadataList.get(i));
        }
        // 11. 若 builder 不为空则将数据放入 response 中并返回
        if (builder != null) {
            Client_NameNode.ListMetaResponse response = builder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            // 8. 如果为空则返回状态异常
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
    }

    /**
     * Client 传入文件哈希值和相对路径进行查询，返回对应文件的所有元数据
     *
     * @param request          文件哈希值和相对路径
     * @param responseObserver 对应文件的所有元数据
     */
    @Override
    public void get(Client_NameNode.GetRequest request, StreamObserver<Client_NameNode.BlockResponse> responseObserver) {
        // 1. 设置错误信息
        String errMessage = "";
        // 2. 获取文件哈希值、路径、路径哈希值
        String fileHash = request.getFileHash();
        String path = request.getRemotePath();
        String pathHash = DigestUtils.md5DigestAsHex(path.getBytes());
        // 3. 创建 builder
        Client_NameNode.BlockResponse.Builder builder = null;
        // 4. 判断文件和路径是否存在
        boolean basicPresent = basicMetadataRepository.findById(fileHash).isPresent();
        boolean folderPresent = folderMetadataRepository.findById(pathHash).isPresent();
        // 5. 设置错误信息
        List<BlockMetadata> blockMetadataList = null;
        if (!basicPresent) {
            errMessage = errMessage + "文件不存在 ";
        } else if (!folderPresent) {
            errMessage = errMessage + " 相对路径不存在";
        } else {
            // 6. 如果文件存在且路径存在则获取列表并返回
            blockMetadataList = blockMetadataMapper.getAllByFileHashSortByAsc(fileHash);
        }
        // 7. 根据列表是否为空返回所有的数据
        if (blockMetadataList != null) {
            for (int i = 0; i < blockMetadataList.size(); i++) {
                builder = Client_NameNode.BlockResponse.newBuilder()
                        .setIsSucceed(true)
                        .setErrMessage(errMessage)
                        .setBlockList(i, blockMetadataList.get(i));
            }
        } else {
            builder = Client_NameNode.BlockResponse.newBuilder()
                    .setIsSucceed(false)
                    .setErrMessage(errMessage)
                    .setBlockList(0, (BlockMetadata) null);
        }
        // 8. 返回
        if (builder != null) {
            Client_NameNode.BlockResponse response = builder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
    }

    /**
     * Client 传入删除文件的哈希值,返回所有删除文件的元数据列表
     *
     * @param request          路径和文件哈希值
     * @param responseObserver 字节片段元数据列表
     */
    @Override
    public void deleteList(Client_NameNode.DeleteRequest request, StreamObserver<Client_NameNode.BlockResponse> responseObserver) {
        // 1. 获取文件哈希值判断文件是否存在
        String fileHash = request.getFileHash();
        boolean present = basicMetadataRepository.findById(fileHash).isPresent();
        // 2. 创建 builder
        Client_NameNode.BlockResponse.Builder builder = null;
        // 3. 如果文件存在则向 MySQL数据库中获取文件元数据，放入 builder 中
        if (present) {
            List<BlockMetadata> list = blockMetadataMapper.getAllByFileHashSortByAsc(fileHash);
            for (int i = 0; i < list.size(); i++) {
                builder = Client_NameNode.BlockResponse.newBuilder()
                        .setIsSucceed(true)
                        .setErrMessage("")
                        .setBlockList(i, list.get(i));
            }
        }
        // 4. 如果文件不存在则builder为空，如果builder为空则代表找不到。
        if (builder == null) {
            builder = Client_NameNode.BlockResponse.newBuilder()
                    .setIsSucceed(false)
                    .setErrMessage("文件不存在")
                    .setBlockList(0, (BlockMetadata) null
                    );

        }
        // 返回
        Client_NameNode.BlockResponse response = builder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void stat(Client_NameNode.StatRequest
                             request, StreamObserver<Client_NameNode.StatResponse> responseObserver) {
        // 1. 获取文件哈希值
        String fileHash = request.getFileHash();
        // 2. 根据文件哈希值获取到对应文件的元数据
        Optional<BasicMetadata> basicMetadata = basicMetadataRepository.findById(fileHash);
        // 3. 通过文件哈希值判断文件是否存在
        boolean present = basicMetadata.isPresent();
        // 4. 创建 builder
        Client_NameNode.StatResponse.Builder builder = null;
        if (present) {
            // 5. 如果文件存在
            builder = Client_NameNode.StatResponse.newBuilder()
                    .setIsSucceed(true)
                    .setErrMessage("")
                    .setBasicMetadata(basicMetadata);
        }
        // 6. 如果文件不存在则builder不存在,现在创建
        if (builder == null) {
            builder = Client_NameNode.StatResponse.newBuilder()
                    .setIsSucceed(false)
                    .setErrMessage("文件不存在")
                    .setBasicMetadata((Client_NameNode.BasicMetadata.Builder) null);
        }
        // 7. 返回
        Client_NameNode.StatResponse response = builder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void list(Client_NameNode.ListMetaRequest
                             request, StreamObserver<Client_NameNode.ListMetaResponse> responseObserver) {
        String path = request.getSourcePath();
        String pathHash = DigestUtils.md5DigestAsHex(path.getBytes());
        List<FolderMetadata> folderMetadataList = folderMetadataRepository.findByParentPathHash(pathHash);
        List<BasicMetadata> basicMetadataList = basicMetadataRepository.findByPathHash(pathHash);
        for (FolderMetadata folderMetadata : folderMetadataList) {
            basicMetadataList.add(folderMetadata.metadata());
        }
        Client_NameNode.ListMetaResponse.Builder builder = null;
        for (int i = 0; i < basicMetadataList.size(); i++) {
            builder = Client_NameNode.ListMetaResponse.newBuilder()
                    .setIsSucceed(true)
                    .setErrMessage("")
                    .setRemotePath(path)
                    .setBasicMetadata(i, basicMetadataList.get(i));
        }
        if (builder == null) {
            builder = Client_NameNode.ListMetaResponse.newBuilder()
                    .setIsSucceed(true)
                    .setErrMessage("")
                    .setRemotePath(path)
                    .setBasicMetadata(0, (Client_NameNode.BasicMetadata) null);
        }
        Client_NameNode.ListMetaResponse response = builder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void mkdir(Client_NameNode.MkdirRequest
                              request, StreamObserver<Client_NameNode.ListMetaResponse> responseObserver) {
        // 1. 获取路径,路径哈希值,路径是否存在
        String path = request.getNewRemotePath();
        String pathHash = DigestUtils.md5DigestAsHex(path.getBytes());
        boolean folderPresent = folderMetadataRepository.findById(pathHash).isPresent();
        if (!folderPresent) {
            // 2. 如果路径不存在则创建文件夹
            createFilePath(path, pathHash);
        }
        // 3. 获取当前路径下的所有内容
        List<BasicMetadata> basicMetadataList = basicMetadataRepository.findByPathHash(pathHash);
        List<FolderMetadata> folderMetadataList = folderMetadataRepository.findByParentPathHash(pathHash);
        for (FolderMetadata folderMetadata : folderMetadataList) {
            basicMetadataList.add(folderMetadata.metadata());
        }
        Client_NameNode.ListMetaResponse.Builder builder = null;
        for (int i = 0; i < basicMetadataList.size(); i++) {
            builder = Client_NameNode.ListMetaResponse.newBuilder()
                    .setIsSucceed(true)
                    .setErrMessage("")
                    .setBasicMetadata(i, basicMetadataList.get(i));
        }
        if (builder == null) {
            builder = Client_NameNode.ListMetaResponse.newBuilder()
                    .setIsSucceed(false)
                    .setErrMessage("新建文件夹出现错误")
                    .setBasicMetadata(0, (Client_NameNode.BasicMetadata) null);
        }
        // 4. 返回
        Client_NameNode.ListMetaResponse response = builder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void createFilePath(String path, String pathHash) {
        String varPathHash = pathHash;
        StringBuilder varPath = new StringBuilder(path);
        while (folderMetadataRepository.findById(varPathHash).isPresent()) {
            // 通过现有路径计算出路径哈希值
            String varPathHash2 = varPathHash;
            // 通过对字符串截取获取文件夹名
            String folderName = varPathHash.substring(varPath.lastIndexOf("/"));
            // 通过对剩余路径计算出父文件夹哈希值
            String parentPath = String.valueOf(varPath.delete(varPath.lastIndexOf("/"), varPath.length()));
            varPathHash = DigestUtils.md5DigestAsHex(parentPath.getBytes());
            // 将对应的数据进行传入
            folderMetadataRepository.save(new FolderMetadata(varPathHash2, folderName, varPathHash));
        }
    }

    /**
     * 文件夹改名操作
     *
     * @param request          文件夹新名称 文件夹旧名称
     * @param responseObserver 是否成功
     */
    @Override
    public void movePath(Client_NameNode.MovePathRequest
                                 request, StreamObserver<Client_NameNode.ListMetaResponse> responseObserver) {
        String newPath = request.getNewPath();
        String newPathHash = DigestUtils.md5DigestAsHex(newPath.getBytes());

        boolean present = folderMetadataRepository.findById(newPathHash).isPresent();
        Client_NameNode.ListMetaResponse.Builder builder = null;
        if (present) {
            // 如果文件夹已经存在
            FolderMetadata folderMetadata = folderMetadataRepository.findById(newPathHash).get();

            List<BasicMetadata> byPathHash = basicMetadataRepository.findByPathHash(folderMetadata.getParentPathHash());
            for (int i = 0; i < byPathHash.size(); i++) {
                builder = Client_NameNode.ListMetaResponse.newBuilder()
                        .setIsSucceed(false)
                        .setErrMessage("文件已存在")
                        .setRemotePath("")
                        .setBasicMetadata(i, byPathHash.get(i));
            }
        } else {
            // 如果文件不存在则修改
            String sourcePath = request.getSourcePath();
            String sourcePathHash = DigestUtils.md5DigestAsHex(sourcePath.getBytes());
            FolderMetadata folderMetadata = folderMetadataRepository.findById(sourcePathHash).get();
            folderMetadataRepository.delete(folderMetadata);
            folderMetadata.setPathHash(newPathHash);
            folderMetadata.setFolderName(newPath.substring(newPath.lastIndexOf("/")));
            StringBuilder varPath = new StringBuilder(newPath);
            folderMetadata.setParentPathHash(String.valueOf(varPath.delete(varPath.lastIndexOf("/"), varPath.length())));
            folderMetadataRepository.save(folderMetadata);

            // 获取文件夹列表
            List<FolderMetadata> folderMetadataList = folderMetadataRepository.findByParentPathHash(sourcePathHash);
            // 获取文件列表
            List<BasicMetadata> basicMetadataList = basicMetadataRepository.findByPathHash(sourcePathHash);

        }

        Client_NameNode.ListMetaResponse response = builder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}