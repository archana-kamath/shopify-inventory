package com.shopify.shopifyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author archa
 * Application class to start the execution 
 */
@SpringBootApplication
@ComponentScan({"com.shopify.shopifyapp","com.shopify.shopifyapp.item"})
@PropertySource(value = {"classpath:application.properties"})
public class ShopifyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopifyappApplication.class, args);
	}

}
