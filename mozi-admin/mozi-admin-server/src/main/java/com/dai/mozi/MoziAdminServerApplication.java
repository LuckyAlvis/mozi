package com.dai.mozi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MoziAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoziAdminServerApplication.class, args);
    }

    @Bean
    RestTemplate template() {
        return new RestTemplate();
    }
}
