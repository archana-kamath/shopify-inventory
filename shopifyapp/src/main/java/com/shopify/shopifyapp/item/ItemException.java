package com.shopify.shopifyapp.item;

/**
 * @author archa
 * All other user defined exception classes will inherit this exception class.
 */
public class ItemException extends Exception {
	public ItemException(String message) {
		super(message);
	}
}
