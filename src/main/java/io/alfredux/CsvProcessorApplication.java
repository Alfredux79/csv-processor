package io.alfredux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
@ImportResource("/integration/csvImport-int.xml")
public class CsvProcessorApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(CsvProcessorApplication.class, args);
	}

}
