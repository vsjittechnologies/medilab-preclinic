package com.medilab.preclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class MedilabPreclinicDepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedilabPreclinicDepartmentServiceApplication.class, args);
	}
	
	@Bean
	public LocalValidatorFactoryBean  localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}

}
