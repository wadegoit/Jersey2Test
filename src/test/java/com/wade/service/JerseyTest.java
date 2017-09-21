
package com.wade.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wade.domain.User;


public class JerseyTest
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private String url = "http://localhost:8080/jersey2Test/rest/users";
	
	@Test
	 public void testGet(){
         System.out.println("****查询所有getAllUsers****");  
         
         Client client = ClientBuilder.newClient();  
         
         WebTarget target = client.target(url);
         Response response = target.request().get();
         String value = response.readEntity(String.class);  
         System.out.println(value);  
         response.close();
	 }
	@Test
	 public void testGet1(){
        System.out.println("****查询所有getAllUsers****");  
        
        Client client = ClientBuilder.newClient();  
        
        WebTarget target = client.target(url+"/1");  
        Response response = target.request().get();
        String value = response.readEntity(String.class);  
        System.out.println(value);  
        response.close();
	 }
	public void testDelete()
	{
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url + "/delete/0");
		Response response = target.request().delete();
		response.close();
	}
	
	public void testUpdate3()
	{
		User user = new User(1, "444444444444", "rrrrrrrrrrrrrrrr");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url + "/update3");
		Response response = target.request().buildPut(Entity.entity(user, MediaType.APPLICATION_XML)).invoke();
		logger.info("update status :{}",response.getStatus());
		logger.info("aa ++");
	}
}
