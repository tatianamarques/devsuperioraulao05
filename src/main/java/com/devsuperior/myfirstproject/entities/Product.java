package com.devsuperior.myfirstproject.entities;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private Double price;
	
	//Porque o produto tem uma categoria
	private Category category;

	//construtor vazio
	public Product() {
		
	}
	
	//construtor gerado com com campos
	
	public Product(long id, String name, Double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	//Getters e Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	// source genarate Hash - para comparação, geralmente usar só o id
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id;
	}
	
	
	
	
	
	
	
	
	
	
}
