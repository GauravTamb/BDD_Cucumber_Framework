package Common_Methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Trigger {

	public static Response Post_trigger(String HeaderName, String HeaderValue, String reqbody, String Endpoint) {

		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.header(HeaderName, HeaderValue);

		requestSpec.body(reqbody);

		Response response = requestSpec.post(Endpoint);

		return response;

	}

	public static Response put_trigger(String HeaderName, String HeaderValue, String reqbody, String Endpoint) {

		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.header(HeaderName, HeaderValue);

		requestSpec.body(reqbody);

		Response response = requestSpec.put(Endpoint);

		return response;
	}

	public static Response patch_trigger(String HeaderName, String HeaderValue, String reqbody, String Endpoint) {

		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.header(HeaderName, HeaderValue);

		requestSpec.body(reqbody);

		Response response = requestSpec.patch(Endpoint);

		return response;
	}

	public static Response get_trigger(String HeaderName, String HeaderValue, String reqbody, String Endpoint) {

		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.header(HeaderName, HeaderValue);

		requestSpec.body(reqbody);

		Response response = requestSpec.get(Endpoint);

		return response;
	}

	public static Response delete_trigger(String HeaderName, String HeaderValue, String reqbody) {

		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.header(HeaderName, HeaderValue);

		requestSpec.body(reqbody);

		Response response = requestSpec.delete("null");

		return response;
	}
}
