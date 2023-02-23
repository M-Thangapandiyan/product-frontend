package com.example.spring.customException;


public class ProductNotFoundException extends Exception{

	public ProductNotFoundException(String meassage) {
		super(meassage);
	}
}
