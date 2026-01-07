package com.jl91software.bridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BridgeApplication {

	public static void main(String[] args) {
		TestConexion tc = new TestConexion();
		tc.conectarAS400();
	}

}
