package br.gmetric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@ComponentScan({
	"br.gmetric.controller",
	"br.gmetric.service",
	"br.gmetric",
	"br.gmetric.security.form",
	"br.gmetric.controller",
	"br.gmetric.controller.security.dto",
	"br.gmetric.controller.security.request",
	"br.gmetric.controller.security.response",
	})
@EntityScan(basePackages = {"br.gmetric.model"} )
@EnableMongoRepositories(basePackages = {"br.gmetric.repository"})
@EnableSpringDataWebSupport
@SpringBootApplication
public class GmetricApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmetricApplication.class, args);
	}

}
