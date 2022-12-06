package com.example.product.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.exception.ResourceNotFoundException;
import com.example.product.model.Product;
import com.example.product.service.ProductRepository;

@RestController
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	// RESTful API methods for Retrieval operations
	@GetMapping("/products")
	public List<Product> list() {
		return productRepository.findAll();
	}
	
	// RESTful API methods for Retrieval of a specific product
	@GetMapping("/product")
	public Product getProduct(@RequestParam int productId) {
		Optional<Product> productOptional = productRepository.findById(productId);
		return productOptional.get();
	}
	
	// RESTful API method for Create operation
	@PostMapping("/saveproduct")
	public @ResponseBody String saveProduct(@RequestBody Product product) {
		productRepository.save(product);
		return "New product saved";
	}

	// RESTful API method for Update operation
	@PutMapping("/updateproduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		
		Product updateProduct = productRepository.findById(product.getProductId()).orElseThrow(
				()-> new ResourceNotFoundException("Product not exist with id: "));
		
		updateProduct.setProductName(product.getProductName());
		updateProduct.setProductPrice(product.getProductPrice());
		productRepository.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/removeproduct")  
	public String deleteUser(@RequestBody Product product)  
	{  
		Product deleteProduct = productRepository.findById(product.getProductId()).orElseThrow(
				()-> new ResourceNotFoundException("Product not exist with id: "));
		productRepository.deleteById(deleteProduct.getProductId());  
		return "Product deleted";
	}  
}
