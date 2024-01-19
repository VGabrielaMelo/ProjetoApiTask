package br.com.agibank.desafioapitask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioApiTaskApplication {

	public static void main(String[] args) {

		SpringApplication.run(DesafioApiTaskApplication.class, args);
	}
}
