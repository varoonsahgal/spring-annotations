package com.intuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


// this class ITSELF is a BEAN!! DemoApplication is a bean
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//no beans.xml anymore in Spring boot
		ApplicationContext ac =      SpringApplication.run(DemoApplication.class, args);
		for(String bean : ac.getBeanDefinitionNames()) {
			System.out.println(bean);
		}
	}

	@Component
	public static class ExampleBean {

	}

	@Configuration
	public static class ExampleConfiguration {
		@Bean
		public String nameBean() {
			return "Varoon";
		}

	}
}
