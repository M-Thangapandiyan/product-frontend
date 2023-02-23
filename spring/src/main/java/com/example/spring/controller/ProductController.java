package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.converter.ProductConvertor;
import com.example.spring.customException.ProductNotFoundException;
import com.example.spring.dto.ProductDto;
import com.example.spring.entity.Product;
import com.example.spring.service.ProductService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@Autowired
	ProductConvertor convertor;

	@PostMapping("/add")
	public ProductDto addProduct(@RequestBody ProductDto productDto) throws ProductNotFoundException {
		return service.saveProduct(productDto);
	}

	@GetMapping("/get")
	public List<ProductDto> findAllProduct() throws ProductNotFoundException {
		List<Product> product = service.getProducts();
		return convertor.entityDto1(product);
	}


	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) throws ProductNotFoundException {
		return service.deleteProduct(id);
	}


	@PutMapping("/update/{id}")
	public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable("id") int id)
			throws ProductNotFoundException {
		Product product = service.updateProduct(convertor.dtoToEntity(productDto), id);
		return convertor.entityToDto(product);
	}
	
	@GetMapping("/get/{id}")
	public Product findProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		return service.getProductById(id) ;
	}
}
