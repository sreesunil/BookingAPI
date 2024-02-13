package com.testautomation.apitesting.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAPIRequest {
	
	@Test
	public void getAllBookings() {
		
		
		Response response = RestAssured
				.given().contentType(ContentType.JSON)
				.baseUri("https://restful-booker.herokuapp.com/booking")
				.when().get();
		
		System.out.println(response.asPrettyString());
		System.out.println("Status Code " + response.getStatusCode());
		
		assertEquals(response.statusCode(), 200);
		Assert.assertTrue(response.getBody().asString().contains("bookingid"));
	}

}
