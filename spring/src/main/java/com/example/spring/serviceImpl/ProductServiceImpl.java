package com.example.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.converter.ProductConvertor;
import com.example.spring.customException.ProductNotFoundException;
import com.example.spring.dao.ProductDao;
import com.example.spring.dto.ProductDto;
import com.example.spring.entity.Product;
import com.example.spring.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao repository;
	
	@Autowired
	ProductConvertor productConvertor;
	
	public ProductDto saveProduct(ProductDto productDto) throws ProductNotFoundException {
		Product product = productConvertor.dtoToEntity(productDto);
		Product product1 = repository.save(product);
		if(null != product1) {
			return productConvertor.entityToDto(product1);
		} else {
			throw new ProductNotFoundException("Product details are null, can not stored");	
		}
	}
	
	public List<Product> getProducts() throws ProductNotFoundException {
		List<Product> products = repository.findAll();
		if (!products.isEmpty() && products != null) {
			return products;
		} else {
			throw new ProductNotFoundException("Product details are null,can not to stored");
		}
	}

	public Product getProductById(int id) throws ProductNotFoundException {
		Product product = repository.findById(id).orElse(null);
		if (null != product) {
			return product;
		} else {
			throw new ProductNotFoundException("Produt not found with id :" + id);
		}
	}

	public String deleteProduct(int id) throws ProductNotFoundException {
		//Product product = repository.findById(id).orElse(null);
		if (0 != id) {
			repository.deleteById(id);  
			return "removed " + id;
		} else {
			throw new ProductNotFoundException("Product not found with id :" + id);
		}
	}

	public Product updateProduct(Product product, int id) throws ProductNotFoundException {
		Product product1 = repository.findById(id).orElse(null);
		if (product != null) {
			product1.setName(product.getName());
			product1.setPrice(product.getPrice());
			product1.setColor(product.getColor());
			return repository.save(product1);
		} else {
			throw new ProductNotFoundException("Product not found with id :" + id);
		}
	}

}
