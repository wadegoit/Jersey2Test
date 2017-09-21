package com.wade.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6556086735562589750L;

	public Book() {
		super();
	}
	public Book(Integer bookID, String bookName) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
	}
	
	private Integer bookID;
	private String bookName;
	
	public Integer getBookID() {
		return bookID;
	}
	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
