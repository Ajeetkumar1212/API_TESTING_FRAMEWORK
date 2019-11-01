package Pojo_Practice_before_Framework;

import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Rest_Assured {
	
	public HashMap map = new HashMap();
	//Request to add 
	@Test(priority =1)
	public void createNewdata()
	{
		map.put("id", 103);
		map.put("firstName", "Ajeeet");
		map.put("lastName", "sharma");
		map.put("email", "hduwhiudhi@gmail.com");
		map.put("programme", "Developer");
		//map.put("lastName", "Pal");
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Java");
		list1.add("Selenium");
		
		map.put("courses", list1);
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://localhost:8095/student")
		.then()
		.statusCode(201)
		.assertThat()
		.body("msg", equalTo("Data added ..."));
	}
	
	///Response from API
	
	@Test(priority=2)
	void getStudentRecord()
	{
		given()
		.when()
		.get("http://localhost:8095/student/103")
		.then()
		.statusCode(200)
		.log().all();
	}

}
