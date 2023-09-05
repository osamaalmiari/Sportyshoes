package com.SportyShoes.website.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SportyShoes.website.models.Products;
import com.SportyShoes.website.repository.ProductRepository;

@RestController
@RequestMapping("products")
public class ProductsController {
	@Autowired
	ProductRepository productrepo;
	

	@RequestMapping("/")
	public String healthCheck() {
		return "OK";
	}

	@PostMapping("addproduct")
	public Products addproduct(@RequestBody Products products) {
		return productrepo.save(products);
	}

	@DeleteMapping("deleteproduct/{id}")
	public void deleteproduct(@PathVariable int id) {
		productrepo.deleteById(id);
	}

	@PutMapping("updateproductdetails/{id}")
	public Products updateproduct(@RequestBody Products products) {
		return productrepo.save(products);
	}
	
	
	
	// this method gets all the data in product table	 
	 public  List<Products> getallproducts() {
		 List<Products> allproducts=(List<Products>) productrepo.findAll(); 
		 return allproducts; 
		 }

	@GetMapping("searchseason/{season}")
	public List<Products> getseason(@PathVariable String season) {
		List<Products> box =new ArrayList<Products>() ; 
		for (int i = 0; i < getallproducts().size(); i++) {
			if (getallproducts().get(i).getSeason().equals(season)) {
				box.add(getallproducts().get(i));
			}
			
		}
		return box;
	 } 
	
	@GetMapping("searchbrand/{brand}")
	public List<Products> getbrand(@PathVariable String brand) {
		List<Products> box =new ArrayList<Products>() ; 
		for (int i = 0; i < getallproducts().size(); i++) {
			if (getallproducts().get(i).getBrand().equals(brand)) {
				box.add(getallproducts().get(i));
			}
			
		}
		return box;
	 } 
	
	@GetMapping("searchcategory/{category}")
	public List<Products> getcategory(@PathVariable String category) {
		List<Products> box =new ArrayList<Products>() ; 
		for (int i = 0; i < getallproducts().size(); i++) {
			if (getallproducts().get(i).getCategory().equals(category)) {
				box.add(getallproducts().get(i));
			}
			
		}
		return box;
	 } 
	
	@GetMapping("searchprice/{price}")
	public List<Products> getprice(@PathVariable int price) {
		List<Products> box =new ArrayList<Products>() ; 
		for (int i = 0; i < getallproducts().size(); i++) {
			if (getallproducts().get(i).getPrice() == price) {
				box.add(getallproducts().get(i));
			}
			
		}
	
		return box;
	 } 
	
	@GetMapping("searchcolor/{color}")
	public List<Products> getcolor(@PathVariable String color) {
		List<Products> box =new ArrayList<Products>() ; 
		for (int i = 0; i < getallproducts().size(); i++) {
			if (getallproducts().get(i).getColor().equals(color)) {
				box.add(getallproducts().get(i));
			}
			
		}
		return box;
	 } 
	
	@GetMapping("searchdate/{createdDate}")
	public List<Products> getcreatedDate(@PathVariable String createdDate) {
		List<Products> box =new ArrayList<Products>() ; 
		for (int i = 0; i < getallproducts().size(); i++) {
			if (getallproducts().get(i).getCreatedDate().equals(createdDate)) {
				box.add(getallproducts().get(i));
			}
			
		}
		return box;
	 } 
}
