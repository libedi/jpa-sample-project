package com.libedi.demo;

import java.util.Optional;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@SpringBootApplication
public class SpringJpaJtaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaJtaApplication.class, args);
	}

	@Bean
    public AuditorAware<Long> auditorAwareImpl() {
        return () -> Optional.of(new Random().nextLong());
    }

}
