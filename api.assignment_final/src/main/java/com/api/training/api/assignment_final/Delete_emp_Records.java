package com.api.training.api.assignment_final;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_emp_Records extends TestBase{
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	void deleteEmp() throws InterruptedException
	{
		logger.info("Delete opration ....");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employee");
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		String empID= jsonPathEvaluator.getString("[0].id");
		response = httpRequest.request(Method.DELETE,"/delete/"+empID);
		Thread.sleep(5);
		
		
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
