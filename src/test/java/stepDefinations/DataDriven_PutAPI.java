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




public class DataDriven_PutAPI {
	String requestBody;
	int statuscode;
	Response response;
	
	@Given("Enter {string} and {string} in put request body")
	public void enter_and_in_put_request_body(String req_name, String req_job) throws IOException {
		File dir_name = Utility.createFileDir("DataDriven_Put_Log_File");
		requestBody = "{\r\n" + "    \"name\": \""+req_name+"\",\r\n" + "    \"job\": \""+req_job+"\"\r\n" + "}";
		String Endpoint = RequestBody.Hostname() + RequestBody.putResource();

		response = API_Trigger.put_trigger(RequestBody.HeaderName(), RequestBody.HeaderValue(), requestBody, Endpoint);

		Utility.evidenceFileCreator(Utility.testLogName("put_case"), dir_name, Endpoint, requestBody,
				response.getHeader("Date"), response.getBody().asString());
	}
	
	@When("Send the put request with data")
	public void send_the_put_request_with_payload() {
		statuscode = response.statusCode();
		String responsebody = response.asPrettyString();

		//System.out.println(responsebody);

		// throw new io.cucumber.java.PendingException();
	}
	@Then("Validate data_driven_put status code")
	public void validate_put_status_code() {
		// Write code here that turns the phrase above into concrete actions

				Assert.assertEquals(response.statusCode(), 200);

				// throw new io.cucumber.java.PendingException();
	}
	@Then("Validate data_driven_put response body parameters")
	public void validate_put_response_body_parameters() throws IOException {
		// Write code here that turns the phrase above into concrete actions

				JsonPath jsp_req = new JsonPath(requestBody);
				Assert.assertEquals(jsp_req.getString("name"), response.jsonPath().getString("name"));
				Assert.assertEquals(jsp_req.getString("job"), response.jsonPath().getString("job"));

				System.out.println("put Response Body Validation Successfull");
				// throw new io.cucumber.java.PendingException();
	}
}
