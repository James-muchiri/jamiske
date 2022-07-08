package com.eshop.jamiske;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;



@SpringBootApplication
@EnableJdbcHttpSession
@EnableAutoConfiguration
@ServletComponentScan
//@EnableSwagger2
public class JamiskeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JamiskeApplication.class, args);
	}
/**
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
**/

}
