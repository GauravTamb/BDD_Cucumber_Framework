package Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_Methods.Utility;

public class RequestBody extends Environment {

	public static String req_post_tc()  {
		String req_body ="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		return req_body;
	}
	
	public static String req_put_tc() {
		String req_body ="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return req_body;
	}
	public static String req_patch_tc() {
		String req_body = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return req_body;			
	}
	public static String req_get_tc() {
		return " ";
	}
	public static String req_delete_tc() {
		return " ";
	}
	
		

}
