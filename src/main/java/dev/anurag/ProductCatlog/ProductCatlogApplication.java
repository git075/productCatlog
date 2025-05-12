package dev.anurag.ProductCatlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductCatlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatlogApplication.class, args);
	}

}
