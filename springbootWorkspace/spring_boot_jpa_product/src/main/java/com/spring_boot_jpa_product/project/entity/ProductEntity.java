package com.spring_boot_jpa_product.project.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring_boot_jpa_product.project.dto.ProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor // enitity가 필요
@AllArgsConstructor // builder가 필요
@Table(name="product")
public class ProductEntity {
	@Id // prdNo를 기본키 컬럼으로 매핑
	private String prdNo;
// 	@Column(name="prd_name") // DB의 컬럼명과 다를 경우 사용가능
	private String prdName;
	private int prdPrice;
	private String prdCompany;
	private int prdStock;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prdDate;
	
	// DTO -> Entity 변환
	public static ProductEntity toEntity(ProductDTO dto) {
		return ProductEntity.builder()
				.prdNo(dto.getPrdNo())
				.prdName(dto.getPrdName())
				.prdPrice(dto.getPrdPrice())
				.prdCompany(dto.getPrdCompany())
				.prdStock(dto.getPrdStock())
				.prdDate(dto.getPrdDate())
				.build();
	}
	
}
