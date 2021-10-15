package com.levy.springboot.grpc.client.cli;

import com.levy.springboot.grpc.client.cli.service.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootGrpcClientApplication implements CommandLineRunner {

    @Autowired
    private GrpcClientService grpcClientService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGrpcClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        grpcClientService.sendMessage("message from client cli.");
    }
}
