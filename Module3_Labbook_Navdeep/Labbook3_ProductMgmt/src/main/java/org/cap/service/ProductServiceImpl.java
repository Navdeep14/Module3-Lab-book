package org.cap.service;

import java.util.List;

import javax.transaction.Transactional;

import org.cap.dao.IProductDao;
import org.cap.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	private IProductDao productDao;
	public IProductDao getProductDao() {
		return productDao;
	}
	@Autowired
	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Product add(Product product) {
		return productDao.add(product);
	}

	@Override
	public List<Product> fetchAll() {
		return productDao.fetchAll();
	}

}
