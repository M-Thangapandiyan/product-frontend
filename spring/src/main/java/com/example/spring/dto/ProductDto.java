package com.example.spring.dto;

public class ProductDto {

	private int id;

	private String name;

	private String color;

	private int price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + "]";
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
