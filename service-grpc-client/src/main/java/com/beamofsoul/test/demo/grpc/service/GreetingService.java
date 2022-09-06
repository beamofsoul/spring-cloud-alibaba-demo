package com.beamofsoul.test.demo.grpc.service;

import com.beamofsoul.test.demo.grpc.GreetingGrpc;
import com.beamofsoul.test.demo.grpc.GreetingRequest;
import com.beamofsoul.test.demo.grpc.GreetingResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @GrpcClient("service-grpc-server")
    private GreetingGrpc.GreetingBlockingStub stub;

    public String sayHello(String name) {
        GreetingRequest request = GreetingRequest.newBuilder().setName(name).build();
        GreetingResponse response = stub.sayHello(request);
        return response.getMessage();
    }
}
