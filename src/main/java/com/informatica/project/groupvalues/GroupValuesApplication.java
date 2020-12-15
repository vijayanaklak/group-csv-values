package com.informatica.project.groupvalues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.informatica.project")
public class GroupValuesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupValuesApplication.class, args);
	}

}
