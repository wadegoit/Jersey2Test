package com.wade.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StuServiceTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private String url = "http://localhost:8080/jersey2Test/rest/students";

	public static void main(String[] args) {
		StuServiceTest stuServiceTest = new StuServiceTest();
		stuServiceTest.testGet();
//		stuServiceTest.testGet1("0");
	}

	public void testGet() {
		logger.info("start {},返回数据格式 Json", "testGet");
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(url);
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		logger.info("Data :{}", value);
		response.close();
	}

	public void testGet1(String userID) {
		logger.info("start {},返回数据格式 XML", "testGet1");
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(url + "/"+userID);
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		logger.info("Data :{}", value);
		response.close();
	}

}
