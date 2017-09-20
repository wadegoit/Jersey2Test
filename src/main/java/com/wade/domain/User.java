
package com.wade.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User
{
	private Integer userID;
	private String userName;
	private String passWord;
	public User(){};
	
	public User(Integer userID, String userName, String passWord)
	{
		super();
		this.userID = userID;
		this.userName = userName;
		this.passWord = passWord;
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
	
	public String getPassWord()
	{
		return passWord;
	}
	
	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}
	
}
