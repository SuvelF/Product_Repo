package com.suvel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suvel.binding.Product;
import com.suvel.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;


	@Override
	public String deleteProductById(Integer id) {
		   productRepo.deleteById(id);
		   if(productRepo.existsById(id)) {
			   return " Product Deleted Successful";
		   }
		return "Product Not Found";
	}

	@Override
	public Product findById(Integer id) {
		
		Optional<Product> product = productRepo.findById(id);
		
		if(product.isPresent()) {
			return product.get();
		}
		return null;
	}

	@Override
	public List<Product> findAll() {
		
		List<Product> productList = productRepo.findAll();
		
		return productList;
	}

	@Override
	public String saveProduct(Product product) {
		productRepo.save(product);
		return "Success";
	}
	
	

	
	
	
}
