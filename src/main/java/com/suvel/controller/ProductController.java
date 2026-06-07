package com.suvel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suvel.binding.Product;
import com.suvel.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productServ;
	
	@PostMapping("/productadd")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		String status = productServ.saveProduct(product);
	    return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	@GetMapping("/getProduct/{pId}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer pId){
		Product product = productServ.findById(pId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{pId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer pId){
		String status = productServ.deleteProductById(pId);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> productList = productServ.findAll();
	   return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
}
