package com.reqres.post.register;

import org.testng.annotations.Test;

import com.reqres.base.ReusableComponents;

import io.restassured.response.Response;
import junit.framework.Assert;

public class UserRegistration extends ReusableComponents {
	@Test
	protected void createUser() {

		try {
			Response response = registerUser();

			// Retrieve response
			Assert.assertEquals(200, response.getStatusCode());
			System.out.println("Response ---------->" + response.getBody().asString());
			System.out.println("Status code ---------->" + response.getStatusCode());

			// additional comments using if else
			if (response.getStatusCode() == 200)
				System.out.println("user registered");
			else {
				System.out.println("user is not registered");
				Assert.fail();
			}
		} catch (Exception e) {
			logger.error("Exception while creating the user in createUser()" + e.getMessage());
		}
	}
}
