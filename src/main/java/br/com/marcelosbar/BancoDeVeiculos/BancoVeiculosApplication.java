package br.com.marcelosbar.BancoDeVeiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BancoVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoVeiculosApplication.class, args);
	}

}
