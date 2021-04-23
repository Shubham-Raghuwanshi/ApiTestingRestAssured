package com.reqres.post.login;

import org.testng.annotations.Test;

import com.reqres.base.ReusableComponents;

import io.restassured.response.Response;
import junit.framework.Assert;

public class UserLogin extends ReusableComponents {
	@Test
	protected void createUser() {

		try {
			Response response = UserLogin();

			// Retrieve response
			Assert.assertEquals(200, response.getStatusCode());
			System.out.println("Response ---------->" + response.getBody().asString());
			System.out.println("Status code ---------->" + response.getStatusCode());

			// additional comments using if else
			if (response.getStatusCode() == 200)
				System.out.println("login successful");
			else {
				System.out.println("login failed");
				Assert.fail();
			}
		} catch (Exception e) {
			logger.error("Exception while creating the user in createUser()" + e.getMessage());
		}
	}
}
