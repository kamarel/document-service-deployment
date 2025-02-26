package com.documents.documentsservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Documents Service Rest APIS Documentation",
				description = "LoginRegistration Service Rest Apis it is part the myKcc microservice",
				version = "3.3.1",
				contact = @Contact(
						name = "myKcc-Project",
						email = "kamarelngunda@gmail.com",
						url = "www.myKcc.com"
				),
				license = @License(
						name = "Apache 3.0",
						url = "www.myKcc.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Documents-service-docs",
				url = "http://www.myKcc.com"
		)
)

@SpringBootApplication
public class DocumentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentsServiceApplication.class, args);
	}

}
