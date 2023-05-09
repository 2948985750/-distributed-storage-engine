package com.hyz.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * NameNode 作为 GRPC 服务端
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: Client_NameNode.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NameNodeRPCGrpc {

  private NameNodeRPCGrpc() {}

  public static final String SERVICE_NAME = "meta.NameNodeRPC";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.BasicMetadata,
      com.hyz.proto.Client_NameNode.ListMetaResponse> getPutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Put",
      requestType = com.hyz.proto.Client_NameNode.BasicMetadata.class,
      responseType = com.hyz.proto.Client_NameNode.ListMetaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.BasicMetadata,
      com.hyz.proto.Client_NameNode.ListMetaResponse> getPutMethod() {
    io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.BasicMetadata, com.hyz.proto.Client_NameNode.ListMetaResponse> getPutMethod;
    if ((getPutMethod = NameNodeRPCGrpc.getPutMethod) == null) {
      synchronized (NameNodeRPCGrpc.class) {
        if ((getPutMethod = NameNodeRPCGrpc.getPutMethod) == null) {
          NameNodeRPCGrpc.getPutMethod = getPutMethod =
              io.grpc.MethodDescriptor.<com.hyz.proto.Client_NameNode.BasicMetadata, com.hyz.proto.Client_NameNode.ListMetaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Put"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.BasicMetadata.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.ListMetaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NameNodeRPCMethodDescriptorSupplier("Put"))
              .build();
        }
      }
    }
    return getPutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.GetRequest,
      com.hyz.proto.Client_NameNode.BlockResponse> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = com.hyz.proto.Client_NameNode.GetRequest.class,
      responseType = com.hyz.proto.Client_NameNode.BlockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.GetRequest,
      com.hyz.proto.Client_NameNode.BlockResponse> getGetMethod() {
    io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.GetRequest, com.hyz.proto.Client_NameNode.BlockResponse> getGetMethod;
    if ((getGetMethod = NameNodeRPCGrpc.getGetMethod) == null) {
      synchronized (NameNodeRPCGrpc.class) {
        if ((getGetMethod = NameNodeRPCGrpc.getGetMethod) == null) {
          NameNodeRPCGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<com.hyz.proto.Client_NameNode.GetRequest, com.hyz.proto.Client_NameNode.BlockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.BlockResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NameNodeRPCMethodDescriptorSupplier("Get"))
              .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.DeleteRequest,
      com.hyz.proto.Client_NameNode.BlockResponse> getDeleteListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteList",
      requestType = com.hyz.proto.Client_NameNode.DeleteRequest.class,
      responseType = com.hyz.proto.Client_NameNode.BlockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.DeleteRequest,
      com.hyz.proto.Client_NameNode.BlockResponse> getDeleteListMethod() {
    io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.DeleteRequest, com.hyz.proto.Client_NameNode.BlockResponse> getDeleteListMethod;
    if ((getDeleteListMethod = NameNodeRPCGrpc.getDeleteListMethod) == null) {
      synchronized (NameNodeRPCGrpc.class) {
        if ((getDeleteListMethod = NameNodeRPCGrpc.getDeleteListMethod) == null) {
          NameNodeRPCGrpc.getDeleteListMethod = getDeleteListMethod =
              io.grpc.MethodDescriptor.<com.hyz.proto.Client_NameNode.DeleteRequest, com.hyz.proto.Client_NameNode.BlockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.BlockResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NameNodeRPCMethodDescriptorSupplier("DeleteList"))
              .build();
        }
      }
    }
    return getDeleteListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.StatRequest,
      com.hyz.proto.Client_NameNode.StatResponse> getStatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Stat",
      requestType = com.hyz.proto.Client_NameNode.StatRequest.class,
      responseType = com.hyz.proto.Client_NameNode.StatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.StatRequest,
      com.hyz.proto.Client_NameNode.StatResponse> getStatMethod() {
    io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.StatRequest, com.hyz.proto.Client_NameNode.StatResponse> getStatMethod;
    if ((getStatMethod = NameNodeRPCGrpc.getStatMethod) == null) {
      synchronized (NameNodeRPCGrpc.class) {
        if ((getStatMethod = NameNodeRPCGrpc.getStatMethod) == null) {
          NameNodeRPCGrpc.getStatMethod = getStatMethod =
              io.grpc.MethodDescriptor.<com.hyz.proto.Client_NameNode.StatRequest, com.hyz.proto.Client_NameNode.StatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Stat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.StatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.StatResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NameNodeRPCMethodDescriptorSupplier("Stat"))
              .build();
        }
      }
    }
    return getStatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.ListMetaRequest,
      com.hyz.proto.Client_NameNode.ListMetaResponse> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.hyz.proto.Client_NameNode.ListMetaRequest.class,
      responseType = com.hyz.proto.Client_NameNode.ListMetaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.ListMetaRequest,
      com.hyz.proto.Client_NameNode.ListMetaResponse> getListMethod() {
    io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.ListMetaRequest, com.hyz.proto.Client_NameNode.ListMetaResponse> getListMethod;
    if ((getListMethod = NameNodeRPCGrpc.getListMethod) == null) {
      synchronized (NameNodeRPCGrpc.class) {
        if ((getListMethod = NameNodeRPCGrpc.getListMethod) == null) {
          NameNodeRPCGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<com.hyz.proto.Client_NameNode.ListMetaRequest, com.hyz.proto.Client_NameNode.ListMetaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.ListMetaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.ListMetaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NameNodeRPCMethodDescriptorSupplier("List"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.MkdirRequest,
      com.hyz.proto.Client_NameNode.ListMetaResponse> getMkdirMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Mkdir",
      requestType = com.hyz.proto.Client_NameNode.MkdirRequest.class,
      responseType = com.hyz.proto.Client_NameNode.ListMetaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.MkdirRequest,
      com.hyz.proto.Client_NameNode.ListMetaResponse> getMkdirMethod() {
    io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.MkdirRequest, com.hyz.proto.Client_NameNode.ListMetaResponse> getMkdirMethod;
    if ((getMkdirMethod = NameNodeRPCGrpc.getMkdirMethod) == null) {
      synchronized (NameNodeRPCGrpc.class) {
        if ((getMkdirMethod = NameNodeRPCGrpc.getMkdirMethod) == null) {
          NameNodeRPCGrpc.getMkdirMethod = getMkdirMethod =
              io.grpc.MethodDescriptor.<com.hyz.proto.Client_NameNode.MkdirRequest, com.hyz.proto.Client_NameNode.ListMetaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Mkdir"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.MkdirRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.ListMetaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NameNodeRPCMethodDescriptorSupplier("Mkdir"))
              .build();
        }
      }
    }
    return getMkdirMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.MovePathRequest,
      com.hyz.proto.Client_NameNode.ListMetaResponse> getMovePathMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MovePath",
      requestType = com.hyz.proto.Client_NameNode.MovePathRequest.class,
      responseType = com.hyz.proto.Client_NameNode.ListMetaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.MovePathRequest,
      com.hyz.proto.Client_NameNode.ListMetaResponse> getMovePathMethod() {
    io.grpc.MethodDescriptor<com.hyz.proto.Client_NameNode.MovePathRequest, com.hyz.proto.Client_NameNode.ListMetaResponse> getMovePathMethod;
    if ((getMovePathMethod = NameNodeRPCGrpc.getMovePathMethod) == null) {
      synchronized (NameNodeRPCGrpc.class) {
        if ((getMovePathMethod = NameNodeRPCGrpc.getMovePathMethod) == null) {
          NameNodeRPCGrpc.getMovePathMethod = getMovePathMethod =
              io.grpc.MethodDescriptor.<com.hyz.proto.Client_NameNode.MovePathRequest, com.hyz.proto.Client_NameNode.ListMetaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MovePath"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.MovePathRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.Client_NameNode.ListMetaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NameNodeRPCMethodDescriptorSupplier("MovePath"))
              .build();
        }
      }
    }
    return getMovePathMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NameNodeRPCStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NameNodeRPCStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NameNodeRPCStub>() {
        @java.lang.Override
        public NameNodeRPCStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NameNodeRPCStub(channel, callOptions);
        }
      };
    return NameNodeRPCStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NameNodeRPCBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NameNodeRPCBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NameNodeRPCBlockingStub>() {
        @java.lang.Override
        public NameNodeRPCBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NameNodeRPCBlockingStub(channel, callOptions);
        }
      };
    return NameNodeRPCBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NameNodeRPCFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NameNodeRPCFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NameNodeRPCFutureStub>() {
        @java.lang.Override
        public NameNodeRPCFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NameNodeRPCFutureStub(channel, callOptions);
        }
      };
    return NameNodeRPCFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * NameNode 作为 GRPC 服务端
   * </pre>
   */
  public static abstract class NameNodeRPCImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 客户端将文件基本数据传入，返回当前路径的所有文件夹和文件的基本数据
     * </pre>
     */
    public void put(com.hyz.proto.Client_NameNode.BasicMetadata request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutMethod(), responseObserver);
    }

    /**
     * <pre>
     * 客户端通过FileHash和远程路径，返回文件元数据
     * </pre>
     */
    public void get(com.hyz.proto.Client_NameNode.GetRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.BlockResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     * <pre>
     * 客户端将发送远程路径和FileHash值，客户端返回删除元素的列表
     * </pre>
     */
    public void deleteList(com.hyz.proto.Client_NameNode.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.BlockResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteListMethod(), responseObserver);
    }

    /**
     * <pre>
     * 以下直接与 NameNode 交互，不用涉及 DataNode
     * 获取某路径下的某文件的基础元数据，右键属性
     * </pre>
     */
    public void stat(com.hyz.proto.Client_NameNode.StatRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.StatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStatMethod(), responseObserver);
    }

    /**
     * <pre>
     * 获取某路径下的所有文件的基础元数据，查看文件夹
     * </pre>
     */
    public void list(com.hyz.proto.Client_NameNode.ListMetaRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     * <pre>
     * 新建文件夹，创建一个新路径
     * </pre>
     */
    public void mkdir(com.hyz.proto.Client_NameNode.MkdirRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMkdirMethod(), responseObserver);
    }

    /**
     * <pre>
     * 移动文件路径
     * </pre>
     */
    public void movePath(com.hyz.proto.Client_NameNode.MovePathRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMovePathMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.hyz.proto.Client_NameNode.BasicMetadata,
                com.hyz.proto.Client_NameNode.ListMetaResponse>(
                  this, METHODID_PUT)))
          .addMethod(
            getGetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.hyz.proto.Client_NameNode.GetRequest,
                com.hyz.proto.Client_NameNode.BlockResponse>(
                  this, METHODID_GET)))
          .addMethod(
            getDeleteListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.hyz.proto.Client_NameNode.DeleteRequest,
                com.hyz.proto.Client_NameNode.BlockResponse>(
                  this, METHODID_DELETE_LIST)))
          .addMethod(
            getStatMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.hyz.proto.Client_NameNode.StatRequest,
                com.hyz.proto.Client_NameNode.StatResponse>(
                  this, METHODID_STAT)))
          .addMethod(
            getListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.hyz.proto.Client_NameNode.ListMetaRequest,
                com.hyz.proto.Client_NameNode.ListMetaResponse>(
                  this, METHODID_LIST)))
          .addMethod(
            getMkdirMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.hyz.proto.Client_NameNode.MkdirRequest,
                com.hyz.proto.Client_NameNode.ListMetaResponse>(
                  this, METHODID_MKDIR)))
          .addMethod(
            getMovePathMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.hyz.proto.Client_NameNode.MovePathRequest,
                com.hyz.proto.Client_NameNode.ListMetaResponse>(
                  this, METHODID_MOVE_PATH)))
          .build();
    }
  }

  /**
   * <pre>
   * NameNode 作为 GRPC 服务端
   * </pre>
   */
  public static final class NameNodeRPCStub extends io.grpc.stub.AbstractAsyncStub<NameNodeRPCStub> {
    private NameNodeRPCStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NameNodeRPCStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NameNodeRPCStub(channel, callOptions);
    }

    /**
     * <pre>
     * 客户端将文件基本数据传入，返回当前路径的所有文件夹和文件的基本数据
     * </pre>
     */
    public void put(com.hyz.proto.Client_NameNode.BasicMetadata request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 客户端通过FileHash和远程路径，返回文件元数据
     * </pre>
     */
    public void get(com.hyz.proto.Client_NameNode.GetRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.BlockResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 客户端将发送远程路径和FileHash值，客户端返回删除元素的列表
     * </pre>
     */
    public void deleteList(com.hyz.proto.Client_NameNode.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.BlockResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 以下直接与 NameNode 交互，不用涉及 DataNode
     * 获取某路径下的某文件的基础元数据，右键属性
     * </pre>
     */
    public void stat(com.hyz.proto.Client_NameNode.StatRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.StatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 获取某路径下的所有文件的基础元数据，查看文件夹
     * </pre>
     */
    public void list(com.hyz.proto.Client_NameNode.ListMetaRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 新建文件夹，创建一个新路径
     * </pre>
     */
    public void mkdir(com.hyz.proto.Client_NameNode.MkdirRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMkdirMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 移动文件路径
     * </pre>
     */
    public void movePath(com.hyz.proto.Client_NameNode.MovePathRequest request,
        io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMovePathMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * NameNode 作为 GRPC 服务端
   * </pre>
   */
  public static final class NameNodeRPCBlockingStub extends io.grpc.stub.AbstractBlockingStub<NameNodeRPCBlockingStub> {
    private NameNodeRPCBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NameNodeRPCBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NameNodeRPCBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 客户端将文件基本数据传入，返回当前路径的所有文件夹和文件的基本数据
     * </pre>
     */
    public com.hyz.proto.Client_NameNode.ListMetaResponse put(com.hyz.proto.Client_NameNode.BasicMetadata request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 客户端通过FileHash和远程路径，返回文件元数据
     * </pre>
     */
    public com.hyz.proto.Client_NameNode.BlockResponse get(com.hyz.proto.Client_NameNode.GetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 客户端将发送远程路径和FileHash值，客户端返回删除元素的列表
     * </pre>
     */
    public com.hyz.proto.Client_NameNode.BlockResponse deleteList(com.hyz.proto.Client_NameNode.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 以下直接与 NameNode 交互，不用涉及 DataNode
     * 获取某路径下的某文件的基础元数据，右键属性
     * </pre>
     */
    public com.hyz.proto.Client_NameNode.StatResponse stat(com.hyz.proto.Client_NameNode.StatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStatMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 获取某路径下的所有文件的基础元数据，查看文件夹
     * </pre>
     */
    public com.hyz.proto.Client_NameNode.ListMetaResponse list(com.hyz.proto.Client_NameNode.ListMetaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 新建文件夹，创建一个新路径
     * </pre>
     */
    public com.hyz.proto.Client_NameNode.ListMetaResponse mkdir(com.hyz.proto.Client_NameNode.MkdirRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMkdirMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 移动文件路径
     * </pre>
     */
    public com.hyz.proto.Client_NameNode.ListMetaResponse movePath(com.hyz.proto.Client_NameNode.MovePathRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMovePathMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * NameNode 作为 GRPC 服务端
   * </pre>
   */
  public static final class NameNodeRPCFutureStub extends io.grpc.stub.AbstractFutureStub<NameNodeRPCFutureStub> {
    private NameNodeRPCFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NameNodeRPCFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NameNodeRPCFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 客户端将文件基本数据传入，返回当前路径的所有文件夹和文件的基本数据
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.hyz.proto.Client_NameNode.ListMetaResponse> put(
        com.hyz.proto.Client_NameNode.BasicMetadata request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 客户端通过FileHash和远程路径，返回文件元数据
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.hyz.proto.Client_NameNode.BlockResponse> get(
        com.hyz.proto.Client_NameNode.GetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 客户端将发送远程路径和FileHash值，客户端返回删除元素的列表
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.hyz.proto.Client_NameNode.BlockResponse> deleteList(
        com.hyz.proto.Client_NameNode.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 以下直接与 NameNode 交互，不用涉及 DataNode
     * 获取某路径下的某文件的基础元数据，右键属性
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.hyz.proto.Client_NameNode.StatResponse> stat(
        com.hyz.proto.Client_NameNode.StatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStatMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 获取某路径下的所有文件的基础元数据，查看文件夹
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.hyz.proto.Client_NameNode.ListMetaResponse> list(
        com.hyz.proto.Client_NameNode.ListMetaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 新建文件夹，创建一个新路径
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.hyz.proto.Client_NameNode.ListMetaResponse> mkdir(
        com.hyz.proto.Client_NameNode.MkdirRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMkdirMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 移动文件路径
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.hyz.proto.Client_NameNode.ListMetaResponse> movePath(
        com.hyz.proto.Client_NameNode.MovePathRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMovePathMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PUT = 0;
  private static final int METHODID_GET = 1;
  private static final int METHODID_DELETE_LIST = 2;
  private static final int METHODID_STAT = 3;
  private static final int METHODID_LIST = 4;
  private static final int METHODID_MKDIR = 5;
  private static final int METHODID_MOVE_PATH = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NameNodeRPCImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NameNodeRPCImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUT:
          serviceImpl.put((com.hyz.proto.Client_NameNode.BasicMetadata) request,
              (io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((com.hyz.proto.Client_NameNode.GetRequest) request,
              (io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.BlockResponse>) responseObserver);
          break;
        case METHODID_DELETE_LIST:
          serviceImpl.deleteList((com.hyz.proto.Client_NameNode.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.BlockResponse>) responseObserver);
          break;
        case METHODID_STAT:
          serviceImpl.stat((com.hyz.proto.Client_NameNode.StatRequest) request,
              (io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.StatResponse>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list((com.hyz.proto.Client_NameNode.ListMetaRequest) request,
              (io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse>) responseObserver);
          break;
        case METHODID_MKDIR:
          serviceImpl.mkdir((com.hyz.proto.Client_NameNode.MkdirRequest) request,
              (io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse>) responseObserver);
          break;
        case METHODID_MOVE_PATH:
          serviceImpl.movePath((com.hyz.proto.Client_NameNode.MovePathRequest) request,
              (io.grpc.stub.StreamObserver<com.hyz.proto.Client_NameNode.ListMetaResponse>) responseObserver);
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

  private static abstract class NameNodeRPCBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NameNodeRPCBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.hyz.proto.Client_NameNode.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NameNodeRPC");
    }
  }

  private static final class NameNodeRPCFileDescriptorSupplier
      extends NameNodeRPCBaseDescriptorSupplier {
    NameNodeRPCFileDescriptorSupplier() {}
  }

  private static final class NameNodeRPCMethodDescriptorSupplier
      extends NameNodeRPCBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NameNodeRPCMethodDescriptorSupplier(String methodName) {
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
      synchronized (NameNodeRPCGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NameNodeRPCFileDescriptorSupplier())
              .addMethod(getPutMethod())
              .addMethod(getGetMethod())
              .addMethod(getDeleteListMethod())
              .addMethod(getStatMethod())
              .addMethod(getListMethod())
              .addMethod(getMkdirMethod())
              .addMethod(getMovePathMethod())
              .build();
        }
      }
    }
    return result;
  }
}
