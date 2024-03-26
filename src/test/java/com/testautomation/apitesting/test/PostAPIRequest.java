package com.testautomation.apitesting.test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import java.io.File;

public class PostAPIRequest {

	@Test
	public void createBooking() {

		JSONObject booking = new JSONObject();
		JSONObject bookingDates = new JSONObject();

		booking.put("firstname", "Sree");
		booking.put("lastname", "Automation");
		booking.put("totalprice", 1245);
		booking.put("depositpaid", true);
		booking.put("additionalneeds", "Breakfast");
		booking.put("bookingdates", bookingDates);

		bookingDates.put("checkin", "2024-03-12");
		bookingDates.put("checkout", "2024-03-20");

		Response response = RestAssured
				.given().contentType(ContentType.JSON)
				.body(booking.toString())
				.baseUri("https://restful-booker.herokuapp.com/booking")
				.log().all()
				.when().post()
				.then().assertThat().statusCode(200)
				.body("booking.firstname", Matchers.equalTo("Sree"))
				.extract().response();
		
		System.out.println(response.asPrettyString());
		
		response.then().assertThat().body(matchesJsonSchema(new File("C:\\JavaPrograms\\RestAssuredAPITesting\\src\\test\\java\\schema\\postschema.json")));
		
		int bookingId = response.path("bookingid");
		
		System.out.println(bookingId);
		
		
		RestAssured
		.given().contentType(ContentType.JSON).baseUri("https://restful-booker.herokuapp.com/booking")
		.pathParam("bookingid", bookingId)
		.when().get("{bookingid}")
		.then().assertThat().statusCode(200);
			

		

	}

}
