package com.seguro.residencial.cotacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan({"com.seguro.residencial.core.model"})
@EnableEurekaClient
@EnableJpaRepositories({"com.seguro.residencial.core.repository"})
@SpringBootApplication
public class CotacaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CotacaoApplication.class, args);
    }
}