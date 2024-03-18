package classes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Main {

	public static void main(String[] args) {
		RestAssured.baseURI = "http://localhost:3000/students";
		Map<String, String> data = new HashMap<>();
		data.put("tourist_name", "abcgdsy");
		data.put("tourist_email", "abcgdsy@gmail.com");
		data.put("tourist_location", "blr");
		Response res = ((ValidatableResponse) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured
				.given().header("content-type", "application/json", new Object[0]).body(data).when().post()).then())
				.statusCode(201)).log().all()).extract().response();
		System.out.println(res.asString());
		System.out.println(res.statusLine().contains("201"));
		System.out.println(res.getStatusLine());
		Map<String, String> cookie = res.getCookies();
		Iterator var4 = cookie.entrySet().iterator();

		while (var4.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry) var4.next();
			System.out.println((String) entry.getKey() + "--" + (String) entry.getValue());

		}

	}

}
