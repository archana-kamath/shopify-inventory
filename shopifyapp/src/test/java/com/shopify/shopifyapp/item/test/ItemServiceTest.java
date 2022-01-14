package com.shopify.shopifyapp.item.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopify.shopifyapp.ShopifyappApplication;
import com.shopify.shopifyapp.item.Item;
import com.shopify.shopifyapp.item.ItemException;
import com.shopify.shopifyapp.item.ItemService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ShopifyappApplication.class })
@PropertySource(value = {"classpath:application.properties"})
@SpringBootTest
class ItemServiceTest {
	
	@Autowired
	ItemService itemService;
	Item item;
	
	@BeforeEach
	void setUp() throws Exception {
		item = new Item();
		item.setItemName("Dell");
		item.setItemCategory("Electronics");
		item.setItemPrice(10D);
		item.setTotalPrice(100D);
		item.setItemQuantity(10L);
		item.setItemRemaining(10L);
		item.setSupplierId(5000L);
		item.setItemURL("https://d1w0m86d4gdmbt.cloudfront.net/filename.jpg");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void itemValidationTest01() throws ItemException {
		String errorMessage = "";
		item.setItemName(null);
		Assertions.assertTrue(itemService.itemValidation(item, errorMessage));
	}

	@Test
	void itemValidationTest02() throws ItemException {
		String errorMessage = "";
		item.setItemName("Dell");
		System.out.println(errorMessage);
		Assertions.assertFalse(itemService.itemValidation(item, errorMessage));
		System.out.println(errorMessage);
	}
}
