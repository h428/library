package com.hao.library.ddd;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.hao.library.ddd.persistence.db")
@EnableJpaRepositories(basePackages = {"com.hao.library.ddd.persistence.dao"})
public class LibraryDddApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryDddApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("启动成功...");
        };
    }

}
