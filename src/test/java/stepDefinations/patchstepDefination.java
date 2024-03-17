package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;

import Common_Methods.API_Trigger;
import Common_Methods.Utility;
import Repository.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class patchstepDefination {

	String requestBody;
	int statuscode;
	Response response;

	@Given("Name and Job in patch request body")
	public void name_and_job_in_request_body() throws IOException {
		// Write code here that turns the phrase above into concrete actions

		File dir_name = Utility.createFileDir("Patch_Log_File");
		requestBody = RequestBody.req_patch_tc();
		String Endpoint = RequestBody.Hostname() + RequestBody.patchResource();

		response = API_Trigger.patch_trigger(RequestBody.HeaderName(), RequestBody.HeaderValue(), requestBody,
				Endpoint);

		Utility.evidenceFileCreator(Utility.testLogName("patch_case"), dir_name, Endpoint, requestBody,
				response.getHeader("Date"), response.getBody().asString());

		// throw new io.cucumber.java.PendingException();
	}

	@When("Send the request with payload to the patch Endpoint")
	public void send_the_request_with_payload_to_the_endpoint() {
		// Write code here that turns the phrase above into concrete actions

		statuscode = response.statusCode();
		String responsebody = response.asPrettyString();

		//System.out.println(responsebody);

		// throw new io.cucumber.java.PendingException();
	}

	@Then("validate patch status code")
	public void validate_status_code() {
		// Write code here that turns the phrase above into concrete actions

		Assert.assertEquals(response.statusCode(), 200);

		// throw new io.cucumber.java.PendingException();
	}

	@Then("validate patch response body parametres")
	public void validate_response_body_parametres() {
		// Write code here that turns the phrase above into concrete actions

		JsonPath jsp_req = new JsonPath(requestBody);
		Assert.assertEquals(jsp_req.getString("name"), response.jsonPath().getString("name"));
		Assert.assertEquals(jsp_req.getString("job"), response.jsonPath().getString("job"));

		System.out.println("Patch Response Body Validation Successfull");
		// throw new io.cucumber.java.PendingException();
	}

}


