package com.hyz.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * DataNodeMonitor 作为 GRPC 服务端
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: NameNode_DataNodeServerMonitor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataNodeMonitorServiceGrpc {

  private DataNodeMonitorServiceGrpc() {}

  public static final String SERVICE_NAME = "meta.DataNodeMonitorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.hyz.proto.NameNode_DataNodeServerMonitor.GetDataNodeLeaderRPCResponse> getGetLeaderRPCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLeaderRPC",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.hyz.proto.NameNode_DataNodeServerMonitor.GetDataNodeLeaderRPCResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.hyz.proto.NameNode_DataNodeServerMonitor.GetDataNodeLeaderRPCResponse> getGetLeaderRPCMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.hyz.proto.NameNode_DataNodeServerMonitor.GetDataNodeLeaderRPCResponse> getGetLeaderRPCMethod;
    if ((getGetLeaderRPCMethod = DataNodeMonitorServiceGrpc.getGetLeaderRPCMethod) == null) {
      synchronized (DataNodeMonitorServiceGrpc.class) {
        if ((getGetLeaderRPCMethod = DataNodeMonitorServiceGrpc.getGetLeaderRPCMethod) == null) {
          DataNodeMonitorServiceGrpc.getGetLeaderRPCMethod = getGetLeaderRPCMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.hyz.proto.NameNode_DataNodeServerMonitor.GetDataNodeLeaderRPCResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLeaderRPC"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hyz.proto.NameNode_DataNodeServerMonitor.GetDataNodeLeaderRPCResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataNodeMonitorServiceMethodDescriptorSupplier("GetLeaderRPC"))
              .build();
        }
      }
    }
    return getGetLeaderRPCMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataNodeMonitorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataNodeMonitorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataNodeMonitorServiceStub>() {
        @java.lang.Override
        public DataNodeMonitorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataNodeMonitorServiceStub(channel, callOptions);
        }
      };
    return DataNodeMonitorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataNodeMonitorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataNodeMonitorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataNodeMonitorServiceBlockingStub>() {
        @java.lang.Override
        public DataNodeMonitorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataNodeMonitorServiceBlockingStub(channel, callOptions);
        }
      };
    return DataNodeMonitorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataNodeMonitorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataNodeMonitorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataNodeMonitorServiceFutureStub>() {
        @java.lang.Override
        public DataNodeMonitorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataNodeMonitorServiceFutureStub(channel, callOptions);
        }
      };
    return DataNodeMonitorServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * DataNodeMonitor 作为 GRPC 服务端
   * </pre>
   */
  public static abstract class DataNodeMonitorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * google.protobuf.Empty 就是无参 / 无返回值的填充字段
     * </pre>
     */
    public void getLeaderRPC(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.hyz.proto.NameNode_DataNodeServerMonitor.GetDataNodeLeaderRPCResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLeaderRPCMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetLeaderRPCMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.hyz.proto.NameNode_DataNodeServerMonitor.GetDataNodeLeaderRPCResponse>(
                  this, METHODID_GET_LEADER_RPC)))
          .build();
    }
  }

  /**
   * <pre>
   * DataNodeMonitor 作为 GRPC 服务端
   * </pre>
   */
  public static final class DataNodeMonitorServiceStub extends io.grpc.stub.AbstractAsyncStub<DataNodeMonitorServiceStub> {
    private DataNodeMonitorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataNodeMonitorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataNodeMonitorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * google.protobuf.Empty 就是无参 / 无返回值的填充字段
     * </pre>
     */
    public void getLeaderRPC(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.hyz.proto.NameNode_DataNodeServerMonitor.GetDataNodeLeaderRPCResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetLeaderRPCMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * DataNodeMonitor 作为 GRPC 服务端
   * </pre>
   */
  public static final class DataNodeMonitorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataNodeMonitorServiceBlockingStub> {
    private DataNodeMonitorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataNodeMonitorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataNodeMonitorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * google.protobuf.Empty 就是无参 / 无返回值的填充字段
     * </pre>
     */
    public java.util.Iterator<com.hyz.proto.NameNode_DataNodeServerMonitor.GetDataNodeLeaderRPCResponse> getLeaderRPC(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetLeaderRPCMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * DataNodeMonitor 作为 GRPC 服务端
   * </pre>
   */
  public static final class DataNodeMonitorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DataNodeMonitorServiceFutureStub> {
    private DataNodeMonitorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataNodeMonitorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataNodeMonitorServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_LEADER_RPC = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataNodeMonitorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataNodeMonitorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LEADER_RPC:
          serviceImpl.getLeaderRPC((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.hyz.proto.NameNode_DataNodeServerMonitor.GetDataNodeLeaderRPCResponse>) responseObserver);
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

  private static abstract class DataNodeMonitorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataNodeMonitorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.hyz.proto.NameNode_DataNodeServerMonitor.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataNodeMonitorService");
    }
  }

  private static final class DataNodeMonitorServiceFileDescriptorSupplier
      extends DataNodeMonitorServiceBaseDescriptorSupplier {
    DataNodeMonitorServiceFileDescriptorSupplier() {}
  }

  private static final class DataNodeMonitorServiceMethodDescriptorSupplier
      extends DataNodeMonitorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataNodeMonitorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataNodeMonitorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataNodeMonitorServiceFileDescriptorSupplier())
              .addMethod(getGetLeaderRPCMethod())
              .build();
        }
      }
    }
    return result;
  }
}
