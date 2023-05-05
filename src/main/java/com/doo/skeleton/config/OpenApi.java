package com.doo.skeleton.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApi {

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
//				.info(new Info()
//						.title("[input]title")
//						.description("[input]description")
//						.version("[input]version")
//						.termsOfService("[input]termsOfService")
//						.summary("[input]summary")
//						.license(new License()
//								.name("[input]name")
//								.url("[input]url"))
//						)
//				.externalDocs(new ExternalDocumentation()
//						.description("[input]SpringShop Wiki Documentation")
//						.url("[input]https://springshop.wiki.github.org/docs"))
				;
	}

}
