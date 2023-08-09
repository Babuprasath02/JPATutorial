package com.example.JPATutorial.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.JPATutorial.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
//	List<Product> findByDateCreatedBetween(LocalDateTime startDate,LocalDateTime endDate);
}
