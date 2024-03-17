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

public class getstepDefination {

	String requestBody;
	int statuscode;
	Response response;
	
	

	@Given("Name and Job in get request body")
	public void name_and_job_in_get_request_body() throws IOException {
	    // Write code here that turns the phrase above into concrete actions

		File dir_name = Utility.createFileDir("Get_Log_File");
		requestBody = RequestBody.req_get_tc();
		String Endpoint = RequestBody.Hostname() + RequestBody.putResource();

		response = API_Trigger.get_trigger(RequestBody.HeaderName(), RequestBody.HeaderValue(), requestBody, Endpoint);

		Utility.evidenceFileCreator(Utility.testLogName("get_case"), dir_name, Endpoint, requestBody,
				response.getHeader("Date"), response.getBody().asString());

		// throw new io.cucumber.java.PendingException();
	}

	@When("Send the request with payload to the get Endpoint")
	public void send_the_request_with_payload_to_the_endpoint() {
		// Write code here that turns the phrase above into concrete actions

		statuscode = response.statusCode();
		String responsebody = response.asPrettyString();

		//System.out.println(responsebody);

		// throw new io.cucumber.java.PendingException();
	}

	@Then("validate get status code")
	public void validate_status_code() {
		// Write code here that turns the phrase above into concrete actions

		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("Get Status Code Validation Successful");

		// throw new io.cucumber.java.PendingException();
	}

	
}


