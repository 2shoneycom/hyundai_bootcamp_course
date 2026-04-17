package com.spring_boot_jpa_product.project.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring_boot_jpa_product.project.dto.ProductDTO;
import com.spring_boot_jpa_product.project.entity.ProductEntity;

@Service
@Primary
public class ProductService implements IProductService {
	@Autowired
	IProductServiceDataHandle productServiceDataHandle;

	@Override
	public ArrayList<ProductDTO> listAllProduct() {
		// dao -> servicedDataHandle에 의해 entity 반환
		ArrayList<ProductEntity> entityList = productServiceDataHandle.listAllProduct();
		// controller에 dto로 전송
		ArrayList<ProductDTO> dtoList = new ArrayList<ProductDTO>();

		for (ProductEntity entity : entityList) {
			ProductDTO dto = ProductDTO.toDTO(entity);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public void insertProduct(ProductDTO prdDto) {
		// dto -> entity 변환해서 전달
		ProductEntity entity = ProductEntity.toEntity(prdDto);
		productServiceDataHandle.insertProduct(entity);
	}

	@Override
	public void updateProduct(ProductDTO prdDto) {
		// dto -> entity 변환해서 전달
		ProductEntity entity = ProductEntity.toEntity(prdDto);
		productServiceDataHandle.updateProduct(entity);
	}

	@Override
	public void deleteProduct(String prdNo) {
		productServiceDataHandle.deleteProduct(prdNo);
	}

	@Override
	public ProductDTO detailViewProduct(String prdNo) {
		Optional<ProductEntity> entity = productServiceDataHandle.detailViewProduct(prdNo);
		// Optional 객체에 저장된 원소 추출하려면 .get()
		ProductDTO dto = ProductDTO.toDTO(entity.get());
		
		return dto;
	}

	@Override
	public String prdNoCheck(String prdNo) {
		return productServiceDataHandle.prdNoCheck(prdNo);
	}
}
