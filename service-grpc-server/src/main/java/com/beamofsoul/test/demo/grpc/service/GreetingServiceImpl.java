package com.beamofsoul.test.demo.grpc.service;

import com.beamofsoul.test.demo.grpc.GreetingGrpc;
import com.beamofsoul.test.demo.grpc.GreetingRequest;
import com.beamofsoul.test.demo.grpc.GreetingResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingGrpc.GreetingImplBase {

    @Override
    public void sayHello(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        System.out.print("#");
        GreetingResponse response = GreetingResponse.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
