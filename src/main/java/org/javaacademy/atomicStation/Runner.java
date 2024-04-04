package org.javaacademy.atomicStation;

import org.javaacademy.atomicStation.economic.FranceEconomicDepartment;
import org.javaacademy.atomicStation.economic.MoroccoEconomicDepartment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Runner {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Runner.class, args);
		NuclearStation nuclearStation = context.getBean(NuclearStation.class);
		nuclearStation.start(3);
	}
}
