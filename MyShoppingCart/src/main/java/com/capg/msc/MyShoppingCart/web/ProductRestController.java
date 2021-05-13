package com.capg.msc.MyShoppingCart.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.msc.MyShoppingCart.beans.Product;
import com.capg.msc.MyShoppingCart.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	private ProductService service;
	
	public ProductRestController() {
		System.out.println("---->> Product Rest constructor");
	}
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : My Shopping App " + LocalDateTime.now();
	}
	
	@PostMapping("/product")
	public Product insertProduct(@RequestBody Product p) {
		service.saveProduct(p);
		return p;
	}
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@PostMapping("/product/delete")
	public boolean deleteProduct(@RequestBody Product p) {
		return service.deleteProduct(p , p.getId());
	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return service.doUpdate(product, product.getId());
	}
	@GetMapping("/products/{category}")
	public List<Product> getAllProductsByCategory(@PathVariable String category)
	{
		return service.getAllProductsByCategory(category);
	}
	
	@GetMapping("/products/{category}/{range1}/{range2}")
	public List<Product> getAllProductsByCategoryAndPrice(@PathVariable String category,
			@PathVariable int range1,@PathVariable int range2)
	{
		return service.getAllProductsByCategoryAndPrice(category, range1, range2);
	}
	
}

