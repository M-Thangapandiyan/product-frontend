package com.example.spring.service;


import java.util.List;

import com.example.spring.customException.ProductNotFoundException;
import com.example.spring.dto.ProductDto;
import com.example.spring.entity.Product;

public interface ProductService {

	public ProductDto saveProduct(ProductDto productDto) throws ProductNotFoundException;

	public List<Product> getProducts() throws ProductNotFoundException;

	public String deleteProduct(int id) throws ProductNotFoundException;

	public Product updateProduct(Product product, int id) throws ProductNotFoundException;
    
	public Product getProductById(int id) throws ProductNotFoundException;
}
