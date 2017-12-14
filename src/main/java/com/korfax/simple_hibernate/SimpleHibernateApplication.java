package com.korfax.simple_hibernate;

import com.korfax.simple_hibernate.workers.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleHibernateApplication implements CommandLineRunner {

	@Autowired
	private Worker worker;

	public static void main(String[] args) {
		SpringApplication.run(SimpleHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		worker.doWork();
	}

}
