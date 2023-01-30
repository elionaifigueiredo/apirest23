package com.pacote.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.pacote")).paths(PathSelectors.regex("/api.*"))
				.build().apiInfo(metaInfo());

	}

	private ApiInfo metaInfo() {
		// TODO Auto-generated method stub

		ApiInfo apiInfo = new ApiInfo("Produtos APi Rest", "Api rest de cadastro de produto", "1.0", "Terms of Service",
				new Contact("Elionai Figueiredo", "https://elionaifigueiredo.com", "elionaifigueiredo@gmail.com"),
				"Aapache License Version 2.0", "https://www.apache.org/license.html", new ArrayList<VendorExtension>()

		);

		return apiInfo;
	}

}
