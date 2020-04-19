package org.cap.dao;

import java.util.List;

import org.cap.entities.Product;

public interface IProductDao {
	Product add(Product product);
	List<Product> fetchAll();
}
