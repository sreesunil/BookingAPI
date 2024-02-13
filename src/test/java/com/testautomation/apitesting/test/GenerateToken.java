package com.testautomation.apitesting.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GenerateToken {

	
	@Test
	public void generateToken() {
		
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.body("{\"username\" :\"admin\",\"password\" :\"password123\"}")
				.baseUri("https://restful-booker.herokuapp.com/auth").log().all()
				.when().post();
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		
		
	}
}
