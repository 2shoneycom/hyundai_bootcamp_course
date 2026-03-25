package bean;

public class ProductVO {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdCompany;
	
	public ProductVO() {
		
	}
	
	public ProductVO(String prdNo, String prdName, int prdPrice, String prdCompany) {
		this.prdNo = prdNo;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
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

	public String getPrdCompany() {
		return prdCompany;
	}

	public void setPrdCompany(String prdCompany) {
		this.prdCompany = prdCompany;
	}
	
	
}
