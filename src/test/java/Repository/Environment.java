package Repository;

public class Environment {

	public static String Hostname() {
		String hostname = "https://reqres.in/";
		return hostname;
	}

	public static String postResource() {
		String resource = "api/users";
		return resource;
	}

	public static String putResource() {
		String resource = "api/users/2";
		return resource;

	}

	public static String patchResource() {
		String resource = "api/users/2";
		return resource;
	}

	public static String getResource() {
		String resource = "api/users/2";
		return resource;

	}

	public static String deleteResource() {
		String Resource = "api/users/2";
		return Resource;

	}

	public static String HeaderName() {

		String headername = "Content-Type";
		return headername;
	}

	public static String HeaderValue() {

		String headervalue = "application/json";
		return headervalue;
	}

}
