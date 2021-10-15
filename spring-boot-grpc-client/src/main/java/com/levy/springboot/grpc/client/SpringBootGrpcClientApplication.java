package com.levy.springboot.grpc.client;

import com.levy.springboot.grpc.client.service.GrpcClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootGrpcClientApplication implements CommandLineRunner {

	@Autowired
	private GrpcClientService grpcClientService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGrpcClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(">>>>>>>>>>>>>>>>>服务启动执行");
		String result = grpcClientService.sendMessage("11");
		log.info("Server response message: {}", result);
	}
}
