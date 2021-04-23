package com.reqres.delete;

import org.testng.annotations.Test;

import com.reqres.base.ReusableComponents;

import io.restassured.response.Response;
import junit.framework.Assert;

public class DeleteUser extends ReusableComponents {
	@Test
	protected void deleteUser() {

		try {
			Response response = deleteRequest();

			// Retrieve response
			Assert.assertEquals(204, response.getStatusCode());
			System.out.println("Response ---------->" + response.getBody().asString());
			System.out.println("Status code ---------->" + response.getStatusCode());

			// additional comments using if else
			if (response.getStatusCode() == 204)
				System.out.println("user deleted");
			else {
				System.out.println("user is not deleted");
				Assert.fail();
			}

		} catch (Exception e) {
			logger.error("Exception while deleting the user in deleteUser()" + e.getMessage());
		}
	}
}
