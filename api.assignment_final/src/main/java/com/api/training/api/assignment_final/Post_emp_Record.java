package com.api.training.api.assignment_final;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_emp_Record extends TestBase {
	RequestSpecification  httpRequest;
	Response response;
	String empName =RestUtils.empName();
	String empSalary =RestUtils.empsal();
	String empAge=RestUtils.empAge();
	
	@BeforeClass
	void createEmp() throws InterruptedException
	{
		logger.info("Post request started...");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		JSONObject reqParams =new JSONObject();
		reqParams.put("name", empName);
		reqParams.put("salary", empSalary);
		reqParams.put("age", empAge);
		
		httpRequest.header("content-Type", "application/json");
		httpRequest.body(reqParams.toString());
		
		response = httpRequest.request(Method.POST,"/create");
		Thread.sleep(5);
		
		
		
	}
	@Test
	void checkResponseBody()
	{
		String resBody = response.getBody().asString();
		Assert.assertEquals(resBody.contains(empName), true);
		Assert.assertEquals(resBody.contains(empSalary), true);
		Assert.assertEquals(resBody.contains(empAge), true);
	}
	@Test
	void checkStatusCode()
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
	    void checkServer()
	    {
	    	String serverType = response.header("Server");
	    	Assert.assertEquals(serverType, "nginx/1.14.1");
	    	
	    }
	
	

}
