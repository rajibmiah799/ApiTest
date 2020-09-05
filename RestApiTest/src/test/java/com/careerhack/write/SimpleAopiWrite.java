package com.careerhack.write;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;// we have to write mannully.

public class SimpleAopiWrite {
	@Test
	public void simpleWrite() {
		Response resp = given().
				body("{\"id\":2,\"title\":\"Mastring Agile\", \"author\":\"Maruf Rahman\"}"). 
				when().
				contentType(ContentType.JSON).
				post("http://localhost:3000/posts");
		int sCode = resp.getStatusCode();
		System.out.println(sCode);
		System.out.println(resp.asString());
		
	}
	@Test 
	public void patchTitle() {
		Response resp = given(). 
				when(). 
				contentType(ContentType.JSON). 
				body("{\"title\":\"Mastring Agile3\"}"). 
				patch("http://localhost:3000/posts/2");
		int sCode = resp.getStatusCode();
		System.out.println(sCode);
		System.out.println(resp.asString());
		
	}
	@Test
	public void simpleWriteR() {
		Response resp = given().
				body("{\"id\":5,\"title\":\"Agile\", \"author\":\"Rajib\"}"). 
				when().
				contentType(ContentType.JSON).
				post("http://localhost:3000/posts");
		int sCode = resp.getStatusCode();
		System.out.println(sCode);
		System.out.println(resp.asString());
	
	}
	@Test 
	public void putTitle() {
		Response resp = given(). 
				when(). 
				contentType(ContentType.JSON). 
				body("{\"title\":\"Mastring\",\"author\":\"miah\"}"). 
				patch("http://localhost:3000/posts/5");
		int sCode = resp.getStatusCode();
		System.out.println(sCode);
		System.out.println(resp.asString());
}
}