package com.spring_mvc.mybatisEx.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BookVO {
	private String bookNo;
	private String bookName;
	private String bookAuthor;
	private int bookPrice;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bookDate;
	private int bookStock;
	
	
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
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
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
	private String pubNo;
}
