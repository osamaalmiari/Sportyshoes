package com.SportyShoes.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SportyShoes.website.controller.ProductsController;

@SpringBootApplication
public class SportyShoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesApplication.class, args);
		/*
		 * for (int i = 0; i < ProductsController.getallproducts().size(); i++) {
		 * System.out.println(ProductsController.getallproducts().get(i)); }
		 */
	}

}
