package com.levy.springboot.grpc.server.service;

import com.levy.springboot.grpc.lib.HelloReply;
import com.levy.springboot.grpc.lib.HelloRequest;
import com.levy.springboot.grpc.lib.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @Auther: Lin.Xia
 * @Date: 2019/3/6 18:15
 */
@Slf4j
@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        log.info("Receive client message from sayHello: {}", request.getName());
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}