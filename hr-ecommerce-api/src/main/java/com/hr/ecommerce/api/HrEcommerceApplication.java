package com.hr.ecommerce.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.hr.ecommerce.product.MongoProductRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = MongoProductRepository.class)
@ComponentScan(basePackages = "com.hr.ecommerce")
public class HrEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrEcommerceApplication.class, args);

	}

}
