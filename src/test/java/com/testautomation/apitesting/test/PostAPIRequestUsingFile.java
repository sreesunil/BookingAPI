package com.testautomation.apitesting.test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.testautomation.apitesting.utils.FileConstants;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;


public class PostAPIRequestUsingFile {
	
	@Test
	public void postAPIRequest() {
		
		try {
			String postAPIRequestBody = FileUtils.readFileToString(new File(FileConstants.POST_REQUEST_BODY),"UTF-8");
			System.out.println(postAPIRequestBody);
			
			Response response = RestAssured
			.given().contentType(ContentType.JSON)
			.body(postAPIRequestBody).baseUri("https://restful-booker.herokuapp.com/booking")
			.when().post()
			.then().assertThat().statusCode(200).extract().response();
			
			JSONArray jsonArray = JsonPath.read(response.body().asString(), "$.booking..firstname");
			
			String fname = (String) jsonArray.get(0);
			assertEquals(fname , "QA1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
