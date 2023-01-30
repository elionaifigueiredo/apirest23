package com.pacote.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private Contact contato() {
		return new Contact("Elionai Figueiredo", "http://www.elionaifigueiredo.com", "elionaifigueiredo@gmail.com");
	}
	
	private ApiInfoBuilder informacoesAPi() {
		
		
		ApiInfoBuilder builder = new ApiInfoBuilder();
		
		builder.title("Title - Api Rest");
		builder.description("Api Exemplo de uso de spring boot api Rest ");
		builder.version("1.1");
		builder.termsOfServiceUrl("Terms of service: Open Source");
		builder.license("Licença - Sua Impresa");
		builder.licenseUrl("https://www.elionaifigueiredo.com");
		builder.contact(this.contato());
		
		return builder;		
		
	}
	
	
	@Bean
	public Docket detalheApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		
		docket
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.pacote"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(this.informacoesAPi().build())
			.consumes(new HashSet<String>(Arrays.asList("application/json")))
			.produces(new HashSet<String>(Arrays.asList("application/json")));
		
		return docket;
			
	}


	
}
