package Pojo_Practice_before_Framework;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.JSONPObject;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmployee {
	
	@Test
	void postNewEmp()
	{
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";	
	RequestSpecification httpRequest = RestAssured.given();
	JSONObject requestParams =new JSONObject();
	requestParams.put("name","Ajeet");
	
	
	}

}
