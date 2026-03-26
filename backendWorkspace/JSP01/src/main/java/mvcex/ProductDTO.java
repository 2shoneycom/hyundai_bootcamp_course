package mvcex;

import java.util.Date;

public class ProductDTO {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private int prdStock;
	private Date prdDate;
	private String prdCompany;
	
	public ProductDTO() {}
	
	public ProductDTO(String prdNo, String prdName, int prdPrice, int prdStock, Date prdDate, String prdCompany) {
		this.prdNo = prdNo;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdStock = prdStock;
		this.prdDate = prdDate;
		this.prdCompany = prdCompany;
	}

	public String getPrdNo() {
		return prdNo;
	}

	public void setPrdNo(String prdNo) {
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

	public int getPrdStock() {
		return prdStock;
	}

	public void setPrdStock(int prdStock) {
		this.prdStock = prdStock;
	}

	public Date getPrdDate() {
		return prdDate;
	}

	public void setPrdDate(Date prdDate) {
		this.prdDate = prdDate;
	}

	public String getPrdCompany() {
		return prdCompany;
	}

	public void setPrdCompany(String prdCompany) {
		this.prdCompany = prdCompany;
	}
}
