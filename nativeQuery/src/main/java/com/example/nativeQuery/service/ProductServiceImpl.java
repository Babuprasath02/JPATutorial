package com.example.nativeQuery.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nativeQuery.model.Products;
import com.example.nativeQuery.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	EntityManager emanager;
	@Autowired
	ProductRepository productRepo;
	@Override
	public List<Products> getAll() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Products getById(long id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	@Override
	public Products updateProduct(Products product, long id) {
		// TODO Auto-generated method stub
		Products existProduct= productRepo.findById(id).orElseThrow();
		existProduct.setName(product.getName());
		existProduct.setDescription(product.getDescription());
		existProduct.setImageUrl(product.getImageUrl());
		existProduct.setActive(product.isActive());
		existProduct.setPrice(product.getPrice());
		existProduct.setSku(product.getSku());
		Products updatedProduct = productRepo.save(existProduct);
		return updatedProduct;
	}

	@Override
	public Products save(Products product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
		
	}
//	
//	public List<Products> getproductswithCriteriaBuilder() {
//		emanager.getTransaction().begin();
//		CriteriaBuilder cb=emanager.getCriteriaBuilder();
//		CriteriaQuery<Products> cq = cb.createQuery(Products.class);
//		Root<Products> productRoot = cq.from(Products.class);
//		cq.select(productRoot.get("name"));
//		CriteriaQuery<Products> select = cq.select(productRoot);
//		TypedQuery<Products> tq = emanager.createQuery(select);
//		
//		return tq.getResultList();
//	}
//
//	@Override
//	public List<Products> getByName(String name) {
//		// TODO Auto-generated method stub
//		return productRepo.NameDetails(name);
//	}

	@Override
	public List<Products> getproductswithCriteriaBuilder() {
		emanager.getTransaction().begin();
		CriteriaBuilder cb=emanager.getCriteriaBuilder();
		CriteriaQuery<Products> cq = cb.createQuery(Products.class);
		Root<Products> productRoot = cq.from(Products.class);
		cq.select(productRoot.get("name"));
		CriteriaQuery<Products> select = cq.select(productRoot);
		TypedQuery<Products> tq = emanager.createQuery(select);
		
		return tq.getResultList();
	}

//	@Override
//	public List<Products> findbynameandsku(String name, String sku) {
//		// TODO Auto-generated method stub
//		emanager.getTransaction().begin();
//		CriteriaBuilder cb = emanager.getCriteriaBuilder();
//		CriteriaQuery<Products> cq = cb.createQuery(Products.class);
//		Root<Products> product = cq.from(Products.class);
//		Predicate namePredicate=cb.equal(product.get("name"), name);
//		Predicate skuPredicate = cb.equal(product.get("sku"), sku);
//		cq.where(namePredicate,skuPredicate);
//		TypedQuery<Products> query = emanager.createQuery(cq);
//		
//		return query.getResultList();
//	}

}
