package com.development.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	
	/**
	 * swagger will change its configuration on returning the docket object
	 * @return
	 */
	@Bean
	public Docket docketConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.development.swagger"))
				.build()
				.apiInfo(customiseApiInfo());
	}

	
	/**
	 * To customise the api information like title, description, contact information
	 * @return
	 */
	private ApiInfo customiseApiInfo() {
		return new ApiInfoBuilder().title("Employee API Documentation")
				.description("Gives the detail of employees in the organisation")
				.version("1.0")
				.contact(new Contact("Jaya Shankar LMS", null, "jayahayagreva@gmail.com"))
				.build();
	}
}
