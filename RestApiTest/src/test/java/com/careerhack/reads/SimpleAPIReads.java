package com.careerhack.reads;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;// we have to write 

public class SimpleAPIReads {

	@Test
	public void simpleGet() {

		Response resp = when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=Astoria&appid=f1bf43a7419a7269fbe361722f775eda");
		System.out.println(resp.asString());

	}

	

	@Test(enabled = true)
	public void simpleGetParam() {

		Response resp = given().
				param("q", "Astoria").
				param("appid", "f1bf43a7419a7269fbe361722f775eda").
				when()
				.get("http://api.openweathermap.org/data/2.5/weather");
		int sCode = resp.getStatusCode();
		System.out.println("status code is " + sCode);

		Assert.assertEquals(sCode, 200);

		System.out.println(resp.asString());
	}
	@Test(enabled = true)
	public void simpleGetParamThen() {

		 given().
				param("q", "Astoria").
				param("appid", "f1bf43a7419a7269fbe361722f775eda").
		 when().
				get("http://api.openweathermap.org/data/2.5/weather"). 
		 then(). 
				assertThat().statusCode(201);
}
	@Test(enabled = false)
	public void readDBJson() {
		Response resp = when().get("http://localhost:3000/posts");
		System.out.println(resp.asString());
	}
}