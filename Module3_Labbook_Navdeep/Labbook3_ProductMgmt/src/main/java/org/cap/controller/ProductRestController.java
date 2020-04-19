package org.cap.controller;

import java.util.List;

import org.cap.dto.ProductDto;
import org.cap.entities.Product;
import org.cap.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
	@Autowired
	private IProductService service;
	
	 @PostMapping("/products/add")
   public ResponseEntity<Product> add(@RequestBody ProductDto dto) {
       Product product = convert(dto);
       product = service.add(product);
       ResponseEntity<Product> response = new ResponseEntity<>(product, HttpStatus.OK);
       return response;
   }
	 Product convert(ProductDto dto) {
		 Product product = new Product();
		 product.setProdId(dto.getProdId());
		 product.setProdName(dto.getProdName());
		 product.setProdPrice(dto.getProdPrice());
		 return product;
   }
	 
	 @GetMapping("/products")
   public ResponseEntity<List<Product>> fetchAll() {
       List<Product> product = service.fetchAll();
       ResponseEntity<List<Product>> response = new ResponseEntity<>(product, HttpStatus.OK);
       return response;
   }
}
