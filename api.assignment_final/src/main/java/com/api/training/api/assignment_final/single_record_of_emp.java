package com.api.training.api.assignment_final;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class single_record_of_emp extends TestBase{
	@BeforeClass
	void getempdata() throws InterruptedException
	{
		logger.info("Employee Info with id only,");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees/"+empID);
		
		Thread.sleep(2);
	}
	@Test
	void checkResBody()
	{
	String res = response.getBody().asString();
	Assert.assertEquals(res.contains(empID),true);
	}
	@Test
	void checkstatusCode()
	{
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
    @Test
    void checkResponseTime()
    {
    	long resTime = response.getTime();
    	Assert.assertTrue(resTime<2000);
    }
    @Test
    void checkstatusLine()
    {
    	String contentType = response.header("Content-Type");
    	Assert.assertEquals(contentType, "text/html");
    }
    @Test
    void checkServer()
    {
    	String serverType = response.header("Server");
    	Assert.assertEquals(serverType, "nginx/1.14.1");
    	
    }
    @Test
    void checkLen()
    {
    	String conLen = response.header("Content-length");
    	//Assert.assertTrue(conLen);
    }
    @AfterClass
    void tearDown()
    {
    	logger.info("All Test - cases finished...");
    }
}
