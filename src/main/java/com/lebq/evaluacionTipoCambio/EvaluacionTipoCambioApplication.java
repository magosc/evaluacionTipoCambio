package com.lebq.evaluacionTipoCambio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EvaluacionTipoCambioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluacionTipoCambioApplication.class, args);
	}

}
