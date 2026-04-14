package com.spring_boot.projectEx.model;

import java.util.ArrayList;

import com.spring_boot.projectEx.dto.ProductDTO;

public interface IProductDAO {
	public ArrayList<ProductDTO> listCtgProduct(String ctdId);
	public ProductDTO detailViewProduct(String prdNo);
}
