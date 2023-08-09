package com.example.nativeQuery.service;

import java.util.List;

import com.example.nativeQuery.model.Products;

public interface ProductService {
	List<Products> getAll();
	Products getById(long id);
	Products updateProduct(Products product,long id);
	Products save(Products product);
	void deleteById(long id);
	List<Products> getproductswithCriteriaBuilder();
//	List<Products> getByName(String name);
//	List<Products> findbynameandsku(String name,String sku);

}
