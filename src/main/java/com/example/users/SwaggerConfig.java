package com.example.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//	The URL for swagger-ui is http://localhost:8080/swagger-ui/
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(metadata())
				.pathMapping("/");
	}

    // Add Details to meta data of the API.
	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("My awesome API")
				.description("My awesome API Description")
				.version("1.0")
				.contact(new Contact("Ranga", "http://www.in28minutes.com",
						"in28minutes@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
}