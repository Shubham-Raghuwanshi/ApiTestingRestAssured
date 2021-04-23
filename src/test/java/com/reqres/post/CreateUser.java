package com.reqres.post;

import org.testng.annotations.Test;

import com.reqres.base.ReusableComponents;

import io.restassured.response.Response;
import junit.framework.Assert;

public class CreateUser extends ReusableComponents {
	@Test
	protected void createUser() {

		try {
			Response response = postRequest();

			// Retrieve response
			Assert.assertEquals(201, response.getStatusCode());
			System.out.println("Response ---------->" + response.getBody().asString());
			System.out.println("Status code ---------->" + response.getStatusCode());
		} catch (Exception e) {
			logger.error("Exception while creating the user in createUser()" + e.getMessage());
		}
	}
}
