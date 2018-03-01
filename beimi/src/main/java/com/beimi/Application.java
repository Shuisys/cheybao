package com.beimi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import com.beimi.core.BMDataContext;


@EnableAutoConfiguration
@SpringBootApplication
@EnableAsync
@EnableJpaRepositories("com.beimi.web.service.repository.jpa")
@EnableElasticsearchRepositories("com.beimi.web.service.repository.es")
public class Application {
    
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class) ;
		BMDataContext.setApplicationContext(springApplication.run(args));
	}
	
}
