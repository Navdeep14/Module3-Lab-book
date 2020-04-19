package org.cap.service;

import java.util.List;

import org.cap.entities.Product;

public interface IProductService {
	Product add(Product product);
	List<Product> fetchAll();
}
