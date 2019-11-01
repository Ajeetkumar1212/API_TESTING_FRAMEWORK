package com.api.training.api.assignment_final;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Get_All_emp extends TestBase {
	@BeforeClass
	void getAllemp() throws InterruptedException
	{
	logger.info("Employee Info,");
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	httpRequest = RestAssured.given();
	response = httpRequest.request(Method.GET,"/employees");
	
	Thread.sleep(2);
	}

	@Test
	void checkResponseBody()
	{
		logger.info("Checking Respose .....");
		String res = response.getBody().asString();
		logger.info("Respose body ===>"+res);
		Assert.assertTrue(res!=null);
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("status code...");
		int status = response.getStatusCode();
		logger.info("Respose body ===>"+status);
		Assert.assertEquals(status,200);
		
	}
	
	@Test
	void checkResponse()
	{
		logger.info("check response time...");
		long resTime = response.getTime();
		logger.info("Respose body ===>"+resTime);
		if(resTime>2000)
			logger.warn("Response time error!");
		Assert.assertTrue(resTime<2000);
	}
	
	@Test
	void checkLine()
	{
		logger.info("check response line...");
		String stLine = response.getStatusLine();
		logger.info("Line msg==>"+stLine);
		Assert.assertEquals(stLine, "HTTP/1.1 200 allright");
	}
	@Test 
	void checkContentType()
	{
		logger.info("checkContentType...");
		String ContentType = response.getStatusLine();
		logger.info("Line msg==>"+ContentType);
		Assert.assertEquals(ContentType, "HTTP/1.1 200 allright");
		
	}
	@Test
	void checkserver()
	{
		logger.info("checkServer...");
		String server = response.header("Server");
		logger.info("Line msg==>"+server);
		Assert.assertEquals(server, "HTTP/1.1 200 allright_server");
	}
	
	@Test
	void checkEncoding()
	{
		logger.info("checkEncodings...");
		String encoding = response.header("Content-Encoding");
		logger.info("Line msg==>"+encoding);
		Assert.assertEquals(encoding, "HTTP/1.1 200 allright_encoding");
	}
	
}
