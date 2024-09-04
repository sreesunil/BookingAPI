package com.testautomation.apitesting.test;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testautomation.apitesting.pojo.Booking;
import com.testautomation.apitesting.pojo.BookingDates;

public class PostAPIRequestUsingPojo {
	
	
	@Test
	public void postAPIRequest() {
		
		
		BookingDates bookingDates = new BookingDates("2023-08-01" ,"2023-08-15");
		Booking booking = new Booking("John", "kennedy", "breakfast", true, 1500, bookingDates);
		
		ObjectMapper objectmapper =new ObjectMapper();
		try {
			String requestBody = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
			System.out.println(requestBody);
			
			// de serialization
			
			Booking bookingDetails = objectmapper.readValue(requestBody, Booking.class);
			System.out.println(bookingDetails.getFirstname());
			System.out.println(bookingDetails.getTotalprice());
			System.out.println(bookingDetails.getBookingdates().getCheckin());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
