package com.spring_mbc.jdbc2.dto;

public class ProductDTO {
	private int prdNo;
	private String prdName;
	private int prdPrice;
	private String prdMaker;
	private String prdColo;
	private int ctgNo;
	
	public int getPrdNo() {
		return prdNo;
	}
	public void setPrdNo(int prdNo) {
		this.prdNo = prdNo;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public int getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}
	public String getPrdMaker() {
		return prdMaker;
	}
	public void setPrdMaker(String prdMaker) {
		this.prdMaker = prdMaker;
	}
	public String getPrdColo() {
		return prdColo;
	}
	public void setPrdColo(String prdColo) {
		this.prdColo = prdColo;
	}
	public int getCtgNo() {
		return ctgNo;
	}
	public void setCtgNo(int ctgNo) {
		this.ctgNo = ctgNo;
	}
}
