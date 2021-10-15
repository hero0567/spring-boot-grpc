package com.levy.springboot.grpc.server.service;

import com.levy.springboot.grpc.lib.HelloReply;
import com.levy.springboot.grpc.lib.HelloRequest;
import com.levy.springboot.grpc.lib.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @Auther: Lin.Xia
 * @Date: 2019/3/6 18:15
 */
@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("GrpcServerService...");
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}