package model;

public class BookDTO {
	String bookNo;
	String bookName;
	String bookAuthor;
	int bookPrice;
	String bookDate;
	int bookStock;
	String pubNo;

	public BookDTO() {}
	
	public BookDTO(String bookNo, String bookName, String bookAuthor, int bookPrice, String bookDate, int bookStock,
			String pubNo) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookDate = bookDate;
		this.bookStock = bookStock;
		this.pubNo = pubNo;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public int getBookStock() {
		return bookStock;
	}

	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}

	public String getPubNo() {
		return pubNo;
	}

	public void setPubNo(String pubNo) {
		this.pubNo = pubNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(bookNo);
		builder.append("\t");
		builder.append(bookName);
		builder.append("\t");
		builder.append(bookAuthor);
		builder.append("\t");
		builder.append(bookPrice);
		builder.append("\t");
		builder.append(bookDate);
		builder.append("\t");
		builder.append(bookStock);
		builder.append("\t");
		builder.append(pubNo);

		return builder.toString();// 더해진 문자열 반환
	}
}
