package com.wade.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7111950751310580166L;
	private Integer userID;
	private String userName;
	private String userNo;
	
	public Student(){};
	
	public Student(Integer userID, String userName, String userNo)
	{
		super();
		this.userID = userID;
		this.userName = userName;
		this.userNo = userNo;
	}

	public Integer getUserID()
	{
		return userID;
	}

	public void setUserID(Integer userID)
	{
		this.userID = userID;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserNo()
	{
		return userNo;
	}

	public void setUserNo(String userNo)
	{
		this.userNo = userNo;
	}
	
}
