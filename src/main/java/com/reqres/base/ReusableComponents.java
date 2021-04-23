package com.reqres.base;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReusableComponents extends BaseTest {

	/**
	 * This method is api setup and returns API request object
	 * 
	 * @author Shubham
	 * @return RequestSpecification
	 */
	private RequestSpecification apiSetup() {
		RequestSpecification httpRequest = null;
		try {
			RestAssured.baseURI = initilizeProperties("baseURI");
			httpRequest = RestAssured.given();
		} catch (Exception e) {
			logger.error("Exception while configuring api in apiSetup()" + e.getMessage());
		}
		return httpRequest;
	}

	/**
	 * This method returns get response object
	 * 
	 * @author Shubham
	 * @return Response
	 */
	public Response getRequest() {
		RequestSpecification httpRequest = apiSetup();
		Response response = null;
		try {
			response = httpRequest.request(Method.GET, initilizeProperties("getUsers"));
		} catch (Exception e) {
			logger.error("Exception while configuring get request in getRequest()" + e.getMessage());
		}
		return response;
	}

	/**
	 * This method returns post response object
	 * 
	 * @author Shubham
	 * @return Response
	 */
	@SuppressWarnings("unchecked")
	public Response postRequest() {
		RequestSpecification httpRequest = apiSetup();
		Response response = null;
		try {
			// request parameters
			JSONObject requestParams = new JSONObject();
			if (initilizeProperties("createUser_headers").contains(";")) {
				String[] headers = initilizeProperties("createUser_headers").split(";");
				for (String header : headers) {
					String[] details = header.split(":");
					requestParams.put(details[0], details[1]);
				}
			} else
				requestParams.put(initilizeProperties("createUser_headers").split(":")[0],
						initilizeProperties("createUser_headers").split(":")[1]);

			httpRequest.header("content-type", "application/json");
			httpRequest.body(requestParams.toJSONString());
			response = httpRequest.request(Method.POST, initilizeProperties("createUser"));
		} catch (Exception e) {
			logger.error("Exception while configuring post request in postRequest()" + e.getMessage());
		}
		return response;
	}

	/**
	 * This method returns delete api response object
	 * 
	 * @author Shubham
	 * @return Response
	 */
	public Response deleteRequest() {
		RequestSpecification httpRequest = apiSetup();
		Response response = null;
		try {
			response = httpRequest.request(Method.DELETE, initilizeProperties("deleteUser"));
		} catch (Exception e) {
			logger.error("Exception while configuring delete request in deleteRequest()" + e.getMessage());
		}
		return response;
	}

	/**
	 * This method returns post response object
	 * 
	 * @see register API :: this is same as Post API(line no. 48) to avoid code
	 *      reusability details from application properties at line no. 14 and 15
	 *      can be replaced with line number 6 and 7 and code from line number 95 to
	 *      118(at ReusableComponents) can be commented
	 * @author Shubham
	 * @return Response
	 */

	@SuppressWarnings("unchecked")
	public Response registerUser() {
		RequestSpecification httpRequest = apiSetup();
		Response response = null;
		try {
			// request parameters
			JSONObject requestParams = new JSONObject();
			if (initilizeProperties("registerUser_headers").contains(";")) {
				String[] headers = initilizeProperties("registerUser_headers").split(";");
				for (String header : headers) {
					String[] details = header.split(":");
					requestParams.put(details[0], details[1]);
				}
			} else
				requestParams.put(initilizeProperties("registerUser_headers").split(":")[0],
						initilizeProperties("registerUser_headers").split(":")[1]);

			httpRequest.header("content-type", "application/json");
			httpRequest.body(requestParams.toJSONString());
			response = httpRequest.request(Method.POST, initilizeProperties("registerUser"));
		} catch (Exception e) {
			logger.error("Exception while registering user in registerUser()" + e.getMessage());
		}
		return response;
	}

	/**
	 * This method returns post response object
	 * 
	 * @see register API :: this is same as Post API(line no. 48) to avoid code
	 *      reusability details from application properties at line no. 14 and 15
	 *      can be replaced with line number 6 and 7 and code from line number 95 to
	 *      118(at ReusableComponents) can be commented
	 * @author Shubham
	 * @return Response
	 */

	@SuppressWarnings("unchecked")
	public Response UserLogin() {
		RequestSpecification httpRequest = apiSetup();
		Response response = null;
		try {
			// request parameters
			JSONObject requestParams = new JSONObject();
			if (initilizeProperties("userLogin_headers").contains(";")) {
				String[] headers = initilizeProperties("userLogin_headers").split(";");
				for (String header : headers) {
					String[] details = header.split(":");
					requestParams.put(details[0], details[1]);
				}
			} else
				requestParams.put(initilizeProperties("userLogin_headers").split(":")[0],
						initilizeProperties("userLogin_headers").split(":")[1]);

			httpRequest.header("content-type", "application/json");
			httpRequest.body(requestParams.toJSONString());
			response = httpRequest.request(Method.POST, initilizeProperties("userLogin"));
		} catch (Exception e) {
			logger.error("Exception while registering user in registerUser()" + e.getMessage());
		}
		return response;
	}
}