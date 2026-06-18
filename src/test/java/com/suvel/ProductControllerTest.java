package com.suvel;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.suvel.binding.Product;
import com.suvel.controller.ProductController;
import com.suvel.service.ProductService;

@org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest(value = ProductController.class)
public class ProductControllerTest {

	@MockitoBean
	private ProductService productService;
	
	@Autowired
	private MockMvc mockMvc;
	
	  @Autowired
	    private tools.jackson.databind.ObjectMapper objectMapper;

	    @Test
	    void testAddProduct() throws Exception {

	        Product product = new Product();
	        product.setPId(101);
	        product.setPName("Laptop");
	        product.setPrice(50000);

	        when(productService.saveProduct(product))
	                .thenReturn("Product Saved Successfully");

	        mockMvc.perform(post("/productadd")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(product)))
	                .andExpect(status().isOk())
	                .andExpect(content().string("Product Saved Successfully"));
	    }
	}