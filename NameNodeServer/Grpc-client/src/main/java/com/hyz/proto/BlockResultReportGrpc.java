package com.hyz.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *  DataNode 作为服务端，NameNode 作为远程函数调用端
 *      背景：Client 的任何【主动操作】（上传/删/下载/修改）经过 NameNode 申请后，Client 直接向 DataNode 操作
 *      todo 明确使用场景
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: NameNode_DataNode.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BlockResultReportGrpc {

  private BlockResultReportGrpc() {}

  public static final String SERVICE_NAME = "meta.BlockResultReport";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.hyz.proto.NameNode_DataNode.BlockListResponse> getGetBlockStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlockStatus",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.hyz.proto.NameNode_DataNode.BlockListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.hyz.proto.NameNode_DataNode.BlockListResponse> getGetBlockStatusMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.hyz.proto.NameNode_DataNode.BlockListResponse> getGetBlockStatusMethod;
    if ((getGetBlockStatusMethod = BlockResultReportGrpc.getGetBlockStatusMethod) == null) {
      synchronized (BlockResultReportGrpc.class) {
        if ((getGetBlockStatusMethod = BlockResultReportGrpc.getGetBlockStatusMethod) == null) {
          BlockResultReportGrpc.getGetBlockStatusMethod = getGetBlockStatusMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.hyz.proto.NameNode_DataNode.BlockListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBlockStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.NameNode_DataNode.BlockListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BlockResultReportMethodDescriptorSupplier("GetBlockStatus"))
              .build();
        }
      }
    }
    return getGetBlockStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BlockResultReportStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlockResultReportStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlockResultReportStub>() {
        @java.lang.Override
        public BlockResultReportStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlockResultReportStub(channel, callOptions);
        }
      };
    return BlockResultReportStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BlockResultReportBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlockResultReportBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlockResultReportBlockingStub>() {
        @java.lang.Override
        public BlockResultReportBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlockResultReportBlockingStub(channel, callOptions);
        }
      };
    return BlockResultReportBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BlockResultReportFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlockResultReportFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlockResultReportFutureStub>() {
        @java.lang.Override
        public BlockResultReportFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlockResultReportFutureStub(channel, callOptions);
        }
      };
    return BlockResultReportFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *  DataNode 作为服务端，NameNode 作为远程函数调用端
   *      背景：Client 的任何【主动操作】（上传/删/下载/修改）经过 NameNode 申请后，Client 直接向 DataNode 操作
   *      todo 明确使用场景
   * </pre>
   */
  public static abstract class BlockResultReportImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 返回某一个文件的 Block 元信息 和所属文件的整体 hash 值
     * </pre>
     */
    public void getBlockStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.hyz.proto.NameNode_DataNode.BlockListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBlockStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetBlockStatusMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.hyz.proto.NameNode_DataNode.BlockListResponse>(
                  this, METHODID_GET_BLOCK_STATUS)))
          .build();
    }
  }

  /**
   * <pre>
   *  DataNode 作为服务端，NameNode 作为远程函数调用端
   *      背景：Client 的任何【主动操作】（上传/删/下载/修改）经过 NameNode 申请后，Client 直接向 DataNode 操作
   *      todo 明确使用场景
   * </pre>
   */
  public static final class BlockResultReportStub extends io.grpc.stub.AbstractAsyncStub<BlockResultReportStub> {
    private BlockResultReportStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlockResultReportStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlockResultReportStub(channel, callOptions);
    }

    /**
     * <pre>
     * 返回某一个文件的 Block 元信息 和所属文件的整体 hash 值
     * </pre>
     */
    public void getBlockStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.hyz.proto.NameNode_DataNode.BlockListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetBlockStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *  DataNode 作为服务端，NameNode 作为远程函数调用端
   *      背景：Client 的任何【主动操作】（上传/删/下载/修改）经过 NameNode 申请后，Client 直接向 DataNode 操作
   *      todo 明确使用场景
   * </pre>
   */
  public static final class BlockResultReportBlockingStub extends io.grpc.stub.AbstractBlockingStub<BlockResultReportBlockingStub> {
    private BlockResultReportBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlockResultReportBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlockResultReportBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 返回某一个文件的 Block 元信息 和所属文件的整体 hash 值
     * </pre>
     */
    public java.util.Iterator<com.hyz.proto.NameNode_DataNode.BlockListResponse> getBlockStatus(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetBlockStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *  DataNode 作为服务端，NameNode 作为远程函数调用端
   *      背景：Client 的任何【主动操作】（上传/删/下载/修改）经过 NameNode 申请后，Client 直接向 DataNode 操作
   *      todo 明确使用场景
   * </pre>
   */
  public static final class BlockResultReportFutureStub extends io.grpc.stub.AbstractFutureStub<BlockResultReportFutureStub> {
    private BlockResultReportFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlockResultReportFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlockResultReportFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_BLOCK_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BlockResultReportImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BlockResultReportImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BLOCK_STATUS:
          serviceImpl.getBlockStatus((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.hyz.proto.NameNode_DataNode.BlockListResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BlockResultReportBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BlockResultReportBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.hyz.proto.NameNode_DataNode.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BlockResultReport");
    }
  }

  private static final class BlockResultReportFileDescriptorSupplier
      extends BlockResultReportBaseDescriptorSupplier {
    BlockResultReportFileDescriptorSupplier() {}
  }

  private static final class BlockResultReportMethodDescriptorSupplier
      extends BlockResultReportBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BlockResultReportMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BlockResultReportGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BlockResultReportFileDescriptorSupplier())
              .addMethod(getGetBlockStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
