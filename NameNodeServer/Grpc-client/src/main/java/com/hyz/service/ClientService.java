package com.hyz.service;

import com.hyz.dao.document.BasicMetadata;
import com.hyz.dao.document.FolderMetadata;
import com.hyz.dao.repository.FolderMetadataRepository;
import com.hyz.proto.Client_NameNode;
import com.hyz.proto.NameNodeRPCGrpc;
import com.hyz.dao.repository.BasicMetadataRepository;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HGD
 * @date 2022/8/30 14:29
 */
@GRpcService
public class ClientService extends NameNodeRPCGrpc.NameNodeRPCImplBase {
    @Resource
    private BasicMetadataRepository basicRepository;
    @Resource
    private FolderMetadataRepository folderRepository;

    /**
     * 用户创建文件，Client 传入基础元数据，返回当前路径下的所有文件基础元数据
     *
     * @param request          Client 传入基础元数据
     * @param responseObserver 返回当前路径下的所有文件基础元数据
     */
    @Override
    public void put(Client_NameNode.BasicMetadata request, StreamObserver<Client_NameNode.ListMetaResponse> responseObserver) {
        // 1. 获取文件哈希值，判断文件是否已经存在
        String fileHash = request.getFileHash();
        boolean present = basicRepository.findById(request.getFileHash()).isPresent();
        // 2. 获取路径和计算出路径哈希值
        String path = request.getPath();
        String pathHash = DigestUtils.md5DigestAsHex(path.getBytes());

        String message = "";
        String remotePath = "";
        if (folderRepository.findById(path).isPresent()) {
            // 3. 如果路径不存在则创建文件夹
            StringBuilder varPath = new StringBuilder(path);
            String varPathHash = pathHash;
            while (folderRepository.findById(varPathHash).isPresent()) {
                String pathName = String.valueOf(varPath.delete(varPath.lastIndexOf("/"), varPath.length() - 1));
                folderRepository.save(new FolderMetadata(varPathHash, pathName, null));
            }

        } else if (present) {
            // 4. 路径存在且有相同文件
            message = "文件元数据存储错误";
            remotePath = "文件元数据存储错误";
        }

        basicRepository.save(new BasicMetadata(
                fileHash,
                pathHash,
                request.getFileName(),
                request.getFileSize(),
                request.getFileExtension(),
                request.getPath(),
                null,
                null
        ));

        // 3. 如果数据存在则搜索当前路径下所有文件的基础元数据
        List<BasicMetadata> basicMetadataList = null;
        if (present) {
            basicMetadataList = basicRepository.findByPath(request.getPath());
        }
        // 4. 将数据放入 response 中并返回
        Client_NameNode.ListMetaResponse response = Client_NameNode.ListMetaResponse.newBuilder().
                setIsSucceed(present).
                setErrMessage(message).
                setRemotePath(remotePath).
                addAllBasicMetadata(basicMetadataList).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * Client 传入文件哈希值和相对路径进行查询，返回对应文件的所有元数据
     *
     * @param request          文件哈希值和相对路径
     * @param responseObserver 对应文件的所有元数据
     */
    @Override
    public void get(Client_NameNode.GetRequest request, StreamObserver<Client_NameNode.BlockResponse> responseObserver) {
        // 1. 通过文件哈希值和相对路径检查对应文件是否存在
        String path = request.getRemotePath();
        String fileHash = request.getFileHash();

        // 2. 将字节片段根据文件内坐标进行升序排序


        // 3. 将数据放入 response 中并返回
    }

    @Override
    public void deleteList(Client_NameNode.DeleteRequest request, StreamObserver<Client_NameNode.BlockResponse> responseObserver) {
        // 1. 通过文件哈希值和相对路径检查对应文件是否存在

        // 2. 将字节片段根据文件内坐标进行升序排序

        // 3. 将数据放入 response 中并返回
    }

    @Override
    public void stat(Client_NameNode.StatRequest request, StreamObserver<Client_NameNode.StatResponse> responseObserver) {
        // 1. 根据文件哈希值和相对路径获取到对应文件的基础元数据

        // 2. 检查基础元数据是否存在

        // 3. 判断所有数据是否存在

        // 4. 将数据放入 response 中并返回
    }

    @Override
    public void list(Client_NameNode.ListMetaRequest request, StreamObserver<Client_NameNode.ListMetaResponse> responseObserver) {

    }

    @Override
    public void mkdir(Client_NameNode.MkdirRequest request, StreamObserver<Client_NameNode.ListMetaResponse> responseObserver) {
        // 需要新建一个文件夹
    }

    @Override
    public void movePath(Client_NameNode.MovePathRequest request, StreamObserver<Client_NameNode.ListMetaResponse> responseObserver) {

    }
}
