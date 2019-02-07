package com.libedi.demo;

import java.util.Optional;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class DemoSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringJpaApplication.class, args);
	}

	@Bean
	public AuditorAware<Long> auditorAwareImpl() {
	    // TODO : Spring Security를 사용한다면  User id 를 보낼 수 있다.
	    return () -> Optional.of(new Random().nextLong());
	}
}

