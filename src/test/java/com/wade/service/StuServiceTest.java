package com.wade.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StuServiceTest
{	
	private Logger logger = LoggerFactory.getLogger(getClass());
	private String url = "http://localhost:8080/jersey2Test/rest/students";
	
	@Test
	 public void testGet(){
		logger.info("****查询所有getAllStudents****");  
        logger.info("start {}","testGet");
        Client client = ClientBuilder.newClient();
        
        WebTarget target = client.target(url);
        Response response = target.request().get();
        String value = response.readEntity(String.class);  
        logger.info("Data :{}",value);
        response.close();
	 }
}
