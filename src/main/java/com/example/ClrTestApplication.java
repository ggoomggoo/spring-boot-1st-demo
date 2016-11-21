package com.example;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;

@SpringBootApplication
@PropertySource("application.properties")
public class ClrTestApplication implements CommandLineRunner{
	
	@Value("${name}")
	private String name;

	public static void main(String[] args) {
		SpringApplication.run(ClrTestApplication.class, args);
		System.out.println("log: main method");
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("log: run method");
		System.out.println("name: " + name);
	}
}

class DefaultRunner implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("log: DefaultRunner run method");
		System.out.println("log: " + arg0[0]);
		System.out.println(
				Arrays.asList(arg0)
				.stream()
				.collect(Collectors.joining(",",
						getClass().getSimpleName() + "[",
						"]"))
				);
		
	}
	
}

@Named @Order(3)
class Runner1 extends DefaultRunner {
}

@Named @Order(1)
class Runner2 extends DefaultRunner {
}

@Named @Order(2)
class Runner3 extends DefaultRunner {
}