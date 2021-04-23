package com.reqres.get;

import org.testng.annotations.Test;
import com.reqres.base.ReusableComponents;
import io.restassured.response.Response;
import junit.framework.Assert;

public class ListUsers extends ReusableComponents {

	@Test
	protected void getListOfUsers() {

		try {
			Response response = getRequest();

			// Retrieve response
			Assert.assertEquals(200, response.getStatusCode(), 200);
			System.out.println("Response ---------->" + response.getBody().asString());
			System.out.println("Status code ---------->" + response.getStatusCode());
		} catch (Exception e) {
			logger.error("Exception while retrieving list of users in getListOfUsers()" + e.getMessage());
		}
	}
}
