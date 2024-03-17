package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;

import Common_Methods.API_Trigger;
import Common_Methods.Utility;
import Repository.RequestBody;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class poststepDefination {

	String requestBody;
	int statuscode;
	Response response;
	File dir_name;
	String Endpoint;
	String responsebody;
	
	@Before 
	public void setup() {
		System.out.println();
	}
	@After
	public void setup1() {
		System.out.println();
	}

	@Given("Name and Job in post request body")
	public void name_and_job_in_request_body() throws IOException {
		// Write code here that turns the phrase above into concrete actions

		dir_name = Utility.createFileDir("Post_Log_File");
		requestBody = RequestBody.req_post_tc();
		Endpoint = RequestBody.Hostname() + RequestBody.postResource();

		response = API_Trigger.Post_trigger(RequestBody.HeaderName(), RequestBody.HeaderValue(), requestBody, Endpoint);

		Utility.evidenceFileCreator(Utility.testLogName("post_case"), dir_name, Endpoint, requestBody,
				response.getHeader("Date"), response.getBody().asString());

		// throw new io.cucumber.java.PendingException();
	}

	@When("Send the request with payload to the post Endpoint")
	public void send_the_request_with_payload_to_the_endpoint() {
		// Write code here that turns the phrase above into concrete actions

		statuscode = response.statusCode();
		 responsebody = response.asPrettyString();

		// System.out.println(responsebody);

		// throw new io.cucumber.java.PendingException();
	}

	@Then("validate post status code")
	public void validate_status_code() {
		// Write code here that turns the phrase above into concrete actions

		Assert.assertEquals(response.statusCode(), 201);

		// throw new io.cucumber.java.PendingException();
	}

	@Then("validate post response body parametres")
	public void validate_response_body_parametres() {
		// Write code here that turns the phrase above into concrete actions

		JsonPath jsp_req = new JsonPath(requestBody);
		Assert.assertEquals(jsp_req.getString("name"), response.jsonPath().getString("name"));
		Assert.assertEquals(jsp_req.getString("job"), response.jsonPath().getString("job"));

		System.out.println("Post Response Body Validation Successfull");
		// throw new io.cucumber.java.PendingException();
	}
}