package com.example.JPATutorial.repositoryTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.example.JPATutorial.model.Product;
import com.example.JPATutorial.repository.ProductRepository;

@SpringBootTest
public class ProductRepositoryTest {
	@Autowired
	ProductRepository productRepo;
//	@Test
//	void saveMethod() {
//		Product prod = new Product();
//		prod.setName("Hair Oil");
//		prod.setDescription("Hair Oil Description");
//		prod.setActive(true);
//		prod.setSku("ADC300");
//		prod.setPrice(new BigDecimal(100));
//		prod.setImageUrl("hairOilUrl");
//		Product saveObj = productRepo.save(prod);
//		System.out.println("--------------------------------"+saveObj.getId());
//		System.out.println(saveObj.toString());
//		
//	}
//	@Test
//	void updateMethod() {
//		long id=2L;
//		Product prod = productRepo.findById(id).get();
//		prod.setName("Wheat Bread");
//		prod.setDescription("Wheat Bread Description");
//		productRepo.save(prod);
//	}
//	@Test
//	void findByIdMethod() {
//		long id=5L;
//		Product prod = productRepo.findById(id).get();
//		System.out.println(prod.toString());
//	}
	
//	@Test
//	void saveAllMethod() {
//		Product prod = new Product();
//		prod.setName("product 8");
//		prod.setDescription("product 8 description");
//		prod.setActive(true);
//		prod.setImageUrl("product 8 Url");
//		prod.setPrice(new BigDecimal(800));
//		prod.setSku("ADC800");
//		
//		Product prod2 = new Product();
//		prod2.setName("product 9");
//		prod2.setDescription("product 9 description");
//		prod2.setActive(true);
//		prod2.setImageUrl("product 9 Url");
//		prod2.setPrice(new BigDecimal(900));
//		prod2.setSku("ADC900");
//		
//		 List<Product> prodObj=productRepo.saveAll(List.of(prod,prod2));
//		 System.out.println(prodObj.toString());
//	}
//	@Test
//	void findAllMethod() {
//		 List<Product> prod = productRepo.findAll();
//		 prod.forEach((p)->{
//			 System.out.println(p.getName());
//		 });
//	}
//	@Test
//	void deleteByIdMethod() {
//		long id=7L;
////		Product prod = productRepo.findById(id).get();
//		productRepo.deleteById(id);
//	}
//	@Test
//	void deleteAllMethod() {
//		
//		//List<Product> prod = productRepo.findAll();
//		productRepo.deleteAll();
//	}
//	@Test
//	void countMethod() {
//		long count = productRepo.count();
//		System.out.println("Total Number of Records:"+count);
//	}
//	@Test
//	void existByIdMethod() {
//		long id=1L;
//		boolean result = productRepo.existsById(id);
//		System.out.println("Result of the Record is "+result);
//	}
//	@Test
//	void findByDateCreatedBetweenMethod() {
//		LocalDateTime startDate = LocalDateTime.of(2023, 07,14,9,56,43);
//		LocalDateTime endDate = LocalDateTime.of(2023, 07,14,10,31,18);
//		List<Product> prod = productRepo.findByDateCreatedBetween(startDate, endDate);
//		prod.forEach((p)->{
//			System.out.println(p.getName());
//			System.out.println(p.getDescription());
//		});
//		
//	}
	@Test
	void sortMultipleFields() {
		String sortByname="sku";
		String sortBydesc="description";
		String sortDir="desc";
		Sort sortByName=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortByname).ascending():Sort.by(sortByname).descending();
		Sort sortByDescription = sortDir.equalsIgnoreCase(Sort.Direction.DESC.name())?
				Sort.by(sortBydesc).ascending():Sort.by(sortBydesc).descending();
		Sort groupBySort = sortByName.and(sortByDescription);
		List<Product> products=productRepo.findAll(groupBySort);
		products.forEach((p)->System.out.println(p));
	}

}
