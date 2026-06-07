package com.suvel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suvel.binding.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
