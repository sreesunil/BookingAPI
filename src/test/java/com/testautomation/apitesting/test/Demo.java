package com.testautomation.apitesting.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.lessThan;

public class Demo {

	@Test
	public void getAllBookings() {

		Response res= RestAssured.given().contentType(ContentType.JSON)
				.baseUri("https://restful-booker.herokuapp.com/booking").when().get()
				.then().assertThat().statusCode(200).time(lessThan(1000L)).extract().response();
				
		System.out.println(res.asPrettyString());
		long time = res.time();
		System.out.println("Response Time : " + time);
			    
				


	}
}