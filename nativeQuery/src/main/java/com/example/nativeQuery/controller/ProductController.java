package com.example.nativeQuery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nativeQuery.model.Products;
import com.example.nativeQuery.repository.ProductRepository;
import com.example.nativeQuery.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService prodService;
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/getAll")
	public List<Products> getAllProducts(){
		return prodService.getAll();
	}
	@GetMapping("/getBycriteria")
	public List<Products> getCriteria(){
		return prodService.getproductswithCriteriaBuilder();
	}
	@GetMapping("getById/{id}")
	public Products getById(@PathVariable long id) {
		return prodService.getById(id);
	}
	@PostMapping("/create")
	public Products create(@RequestBody Products prod) {
		return prodService.save(prod);
	}
	@PutMapping("/update/{id}")
	public Products updateProduct(@RequestBody Products prod, @PathVariable long id) {
		return prodService.updateProduct(prod, id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable long id) {
		prodService.deleteById(id);
	}
//	@GetMapping("/getByName/{name}")
//	public List<Products> getProductByName(@PathVariable String name){
//		return prodService.getByName(name);
//	}
	
	@GetMapping("/getByName/{name}")
	public List<Products> getProductByName(@PathVariable String name){
		List<Products> user= productRepo.NameDetails(name);
		return user;
		
	}
	@GetMapping("getBySku/{sku}")
	public List<Products> getProductBySku(@PathVariable String sku){
		List<Products> getsku=productRepo.skuDetails(sku);
		return getsku;
	}
	@GetMapping("/getnameandsku/{name}/{sku}")
	public List<Products> getproductnameandsku(@PathVariable String name,@PathVariable String sku){
		List<Products> getnamesku=productRepo.nameandskuDetails(name, sku);
		return getnamesku;
	}
	
//	@GetMapping("/findbynameandsku/{name}/{sku}")
//	public List<Products> getnameandsku(@PathVariable String name,@PathVariable String sku){
//		List<Products> getnamesku=prodService.findbynameandsku(name, sku);
//		return getnamesku;
//	}

}
