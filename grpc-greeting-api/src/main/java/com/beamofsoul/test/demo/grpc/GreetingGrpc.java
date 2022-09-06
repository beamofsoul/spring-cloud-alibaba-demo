package com.beamofsoul.test.demo.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.34.1)",
    comments = "Source: Greeting.proto")
public final class GreetingGrpc {

  private GreetingGrpc() {}

  public static final String SERVICE_NAME = "com.beamofsoul.test.demo.grpc.Greeting";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.beamofsoul.test.demo.grpc.GreetingRequest,
      com.beamofsoul.test.demo.grpc.GreetingResponse> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayHello",
      requestType = com.beamofsoul.test.demo.grpc.GreetingRequest.class,
      responseType = com.beamofsoul.test.demo.grpc.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.beamofsoul.test.demo.grpc.GreetingRequest,
      com.beamofsoul.test.demo.grpc.GreetingResponse> getSayHelloMethod() {
    io.grpc.MethodDescriptor<com.beamofsoul.test.demo.grpc.GreetingRequest, com.beamofsoul.test.demo.grpc.GreetingResponse> getSayHelloMethod;
    if ((getSayHelloMethod = GreetingGrpc.getSayHelloMethod) == null) {
      synchronized (GreetingGrpc.class) {
        if ((getSayHelloMethod = GreetingGrpc.getSayHelloMethod) == null) {
          GreetingGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<com.beamofsoul.test.demo.grpc.GreetingRequest, com.beamofsoul.test.demo.grpc.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.beamofsoul.test.demo.grpc.GreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.beamofsoul.test.demo.grpc.GreetingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GreetingMethodDescriptorSupplier("sayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreetingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetingStub>() {
        @java.lang.Override
        public GreetingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetingStub(channel, callOptions);
        }
      };
    return GreetingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreetingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetingBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetingBlockingStub>() {
        @java.lang.Override
        public GreetingBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetingBlockingStub(channel, callOptions);
        }
      };
    return GreetingBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreetingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetingFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetingFutureStub>() {
        @java.lang.Override
        public GreetingFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetingFutureStub(channel, callOptions);
        }
      };
    return GreetingFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GreetingImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(com.beamofsoul.test.demo.grpc.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.beamofsoul.test.demo.grpc.GreetingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.beamofsoul.test.demo.grpc.GreetingRequest,
                com.beamofsoul.test.demo.grpc.GreetingResponse>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class GreetingStub extends io.grpc.stub.AbstractAsyncStub<GreetingStub> {
    private GreetingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetingStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(com.beamofsoul.test.demo.grpc.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.beamofsoul.test.demo.grpc.GreetingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GreetingBlockingStub extends io.grpc.stub.AbstractBlockingStub<GreetingBlockingStub> {
    private GreetingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetingBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.beamofsoul.test.demo.grpc.GreetingResponse sayHello(com.beamofsoul.test.demo.grpc.GreetingRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GreetingFutureStub extends io.grpc.stub.AbstractFutureStub<GreetingFutureStub> {
    private GreetingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.beamofsoul.test.demo.grpc.GreetingResponse> sayHello(
        com.beamofsoul.test.demo.grpc.GreetingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreetingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreetingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.beamofsoul.test.demo.grpc.GreetingRequest) request,
              (io.grpc.stub.StreamObserver<com.beamofsoul.test.demo.grpc.GreetingResponse>) responseObserver);
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

  private static abstract class GreetingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreetingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.beamofsoul.test.demo.grpc.GreetingOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeting");
    }
  }

  private static final class GreetingFileDescriptorSupplier
      extends GreetingBaseDescriptorSupplier {
    GreetingFileDescriptorSupplier() {}
  }

  private static final class GreetingMethodDescriptorSupplier
      extends GreetingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreetingMethodDescriptorSupplier(String methodName) {
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
      synchronized (GreetingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreetingFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
