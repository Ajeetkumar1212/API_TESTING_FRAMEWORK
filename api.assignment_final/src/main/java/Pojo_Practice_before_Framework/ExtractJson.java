package Pojo_Practice_before_Framework;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ExtractJson {
	@Test 
	void test_data()
	{
	RestAssured.baseURI="http://127.0.0.1:8095";
	RestAssured.basePath="/student";
	
	Response res = given().contentType(ContentType.JSON).log().all().get("/99");
	System.out.print(res);
	String email = given()
	.contentType(ContentType.JSON).log().all()
	.get("/99").then().extract().path("email");
	
	res.prettyPrint();
	System.out.print(email);
	}
	
	
	class Data {
	    private int id;
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getProgramme() {
			return programme;
		}
		public void setProgramme(String programme) {
			this.programme = programme;
		}
		public List<Data> getCourses() {
			return courses;
		}
		public void setCourses(List<Data> courses) {
			this.courses = courses;
		}
		private String firstName;
	    private String lastName;
	    private String email;
	    private String programme;
	    private List<Data> courses;

	    

}
}
