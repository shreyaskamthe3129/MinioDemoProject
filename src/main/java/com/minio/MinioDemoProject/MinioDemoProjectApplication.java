package com.minio.MinioDemoProject;

import com.minio.MinioDemoProject.test.MinIOObjectCRUD;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinioDemoProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MinioDemoProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new MinIOObjectCRUD().getListOfObjects().forEach(object -> {
			System.out.println(object);
		});
	}
}
