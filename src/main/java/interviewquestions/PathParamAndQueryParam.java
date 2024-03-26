package interviewquestions;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PathParamAndQueryParam {
	
	
	@Test
	public void PathParamAndQueryParam() {
		
		
		RestAssured
		.given().contentType(ContentType.JSON).baseUri("https://reqres.in/api")
		.pathParam("mypath", "users").queryParam("page", 2)
		.when().get("{mypath}")
		.then().assertThat().statusCode(200).log().all();
		
		
		
	}
	

}
