package br.com.agrotis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"br.com.agrotis", "br.com.agrotis.controller", "com.repositories", "br.com.agrotis.service", "br.com.agrotis.model"})
@EntityScan(basePackages = {"br.com.agrotis.model"})
@EnableJpaRepositories(basePackages = {"br.com.agrotis.model"})
@EnableTransactionManagement
@SpringBootApplication
public class AgrotisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgrotisApplication.class, args);
	}
}
