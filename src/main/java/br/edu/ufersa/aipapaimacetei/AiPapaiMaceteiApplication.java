package br.edu.ufersa.aipapaimacetei;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AiPapaiMaceteiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiPapaiMaceteiApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
