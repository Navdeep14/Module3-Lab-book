package org.cap.controller;


import java.util.List;
import org.cap.entities.Product;
import org.cap.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ProductController {
	 private static Logger Log= LoggerFactory.getLogger(ProductController.class);

	    @Autowired
	    private IProductService	productService;
	    @GetMapping("/register")
	    public ModelAndView registerPage() {
	        return new ModelAndView("productregister");// only provide view name
	    }

	    @GetMapping("/processregister")
	    public ModelAndView registerEmployee(@RequestParam("prodId") int prodId,@RequestParam("prodName") String prodName,@RequestParam("prodPrice") double prodPrice) {
	    	Product product = new Product();
	    	product.setProdId(prodId);
	    	product.setProdName(prodName);
	    	product.setProdPrice(prodPrice);
	        product=productService.add(product);
	        return new ModelAndView("productdetails",  "product", product);
	    }
	    @GetMapping("/fetchall")
	    public ModelAndView fetchallProduct() {
	    	 List <Product> store1=productService.fetchAll();
	        return new ModelAndView("fetchall","fetch",store1);
	    }

}
