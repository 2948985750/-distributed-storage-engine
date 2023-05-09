package com.hyz.service.impl;

import com.google.protobuf.Empty;
import com.hyz.proto.BlockResultReportGrpc;
import com.hyz.proto.NameNode_DataNode;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;

import java.util.List;

/**
 * @author HGD
 * @date 2022/9/4 11:03
 */
public class NnDnService {
    @GrpcClient("grpc_server")
    private BlockResultReportGrpc.BlockResultReportBlockingStub stub;

    public void inputBlockResultReport() {

    }
}
