package br.com.octopus.viaCep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ViaCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViaCepApplication.class, args);
	}
}
