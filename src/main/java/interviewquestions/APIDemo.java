package interviewquestions;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APIDemo {
	
	
	@Test
	public void TC01() {
		
		Map<String,String> payload = new HashMap<String ,String>();
		
		payload.put("username", "ammuedamana@tekarch.com");
		payload.put("password", "Admin123");
		
		RestAssured
		.given().contentType(ContentType.JSON)
		.baseUri("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net")
		.when().body(payload).post("/login")
		.then()
	    .statusCode(anyOf(is(201),is(401))).log().all();
		
		
	}
	
	
}
