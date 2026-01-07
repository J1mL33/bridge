package com.jl91software.bridge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BridgeApplication {

	@Autowired
	private TestConexion tc;

	public static void main(String[] args) {
		SpringApplication.run(BridgeApplication.class, args);
	}

	@Bean
	public CommandLineRunner runAfterStartup() {
		return args -> {

			System.out.println("Ejecutando conexión al inicio...");
			tc.conectarAS400();
		};
	}

}
