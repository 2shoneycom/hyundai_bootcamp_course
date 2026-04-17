package com.spring_boot_jpa_product.project.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring_boot_jpa_product.project.entity.ProductEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDTO {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdCompany;
	private int prdStock;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prdDate;
	
	// Entity -> DTO 변환하는 메소드 (builder 패턴 활용)
	public static ProductDTO toDTO(ProductEntity entity) {
		return ProductDTO.builder()			// ProductDTOBuilder 클래스 객체 인스턴스 반환
				.prdNo(entity.getPrdNo())
				.prdName(entity.getPrdName())
				.prdPrice(entity.getPrdPrice())
				.prdCompany(entity.getPrdCompany())
				.prdStock(entity.getPrdStock())
				.prdDate(entity.getPrdDate()) 		// builder 클래스 필드에 값을 저장 
				.build();	// ProductDTO 객체 생성 후 builder 클래스 필에 값을 dto로 저장 후 dto 객체 반환
				// 생성자 호출해서 dto 객체 생성
	}
}
