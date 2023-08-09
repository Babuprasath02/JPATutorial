package com.example.nativeQuery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.nativeQuery.model.Products;
public interface ProductRepository extends JpaRepository<Products,Long>{
	@Query(value="select * from tbl_products e where e.name=?1",nativeQuery=true)//In Native Query we are using database table name
	List<Products> NameDetails(String name);
	
	@Query("select t from Products t where t.sku=:sku")//In JPQL we are using entity name
	List<Products> skuDetails(@Param("sku") String sku);
	@Query(value="select * from tbl_products e where e.name=?1 and e.sku=?2",nativeQuery=true)
	List<Products> nameandskuDetails(String name,String sku);
	
}
