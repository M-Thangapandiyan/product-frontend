package com.example.spring.converter;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.spring.dto.ProductDto;
import com.example.spring.entity.Product;

@Component
public class ProductConvertor {

	public ProductDto  entityToDto(Product product ) {
		ModelMapper mapper = new ModelMapper();
		ProductDto map = mapper.map(product, ProductDto.class);
		return map;
	}
	
	public List<ProductDto> entityDto1 (List<Product> product) {
		List<ProductDto> s = new ArrayList<ProductDto>();
		for(Product d : product) {
			s.add(entityToDto(d));
		}
		return s;
	}
	
	public Product dtoToEntity(ProductDto productDto) {
		ModelMapper mapper = new ModelMapper();
		Product product = mapper.map(productDto,Product.class);
		return product;
		
	}
}
