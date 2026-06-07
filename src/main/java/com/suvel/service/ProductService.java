package com.suvel.service;

import java.util.List;

import com.suvel.binding.Product;

public interface ProductService {

	public String saveProduct(Product product);
	
	public String deleteProductById(Integer id);

	public Product findById(Integer id);
	
	public List<Product> findAll();

}
