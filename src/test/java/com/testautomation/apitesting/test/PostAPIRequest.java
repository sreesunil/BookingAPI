package com.testautomation.apitesting.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class PostAPIRequest {

	@Test
	public void createBooking() {

		JSONObject booking = new JSONObject();
		JSONObject bookingDates = new JSONObject();

		booking.put("firstname", "QA");
		booking.put("lastname", "Automation");
		booking.put("totalprice", 1245);
		booking.put("depositpaid", true);
		booking.put("additionalneeds", "Breakfast");
		booking.put("bookingdates", bookingDates);

		bookingDates.put("checkin", "2024-03-12");
		bookingDates.put("checkout", "2024-03-20");

		Response response = RestAssured.given().contentType(ContentType.JSON)
				.body(booking.toString())
				.baseUri("https://restful-booker.herokuapp.com/booking")
				.log().all().when().post();

		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());

	}

}
