package com.spring_boot_jpa_product.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring_boot_jpa_product.project.entity.ProductEntity;

// @Repository
// @Query : JPQL 
// Repo 사용 entity와 기본키 타입을 전달해야 repo 사용 가능
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
	// 아무것도 안적어도 기본 CRUD 메소드 지공
	
	// low 쿼리 사용하더라도 entity를 테이블처럼 사용해야 함
	@Query(value="SELECT p.prdNo From ProductEntity p WHERE p.prdNo=:prdNo")
	String searchById(@Param("prdNo") String prdNo);
}
