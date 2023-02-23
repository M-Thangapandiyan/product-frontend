package com.example.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}