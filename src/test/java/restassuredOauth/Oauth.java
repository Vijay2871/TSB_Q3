package restassuredOauth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class Oauth {

	String consumerKey="F785BCFF01FDAAA50C30FA1FD63B2F10";
	String consumerSecret="89D835B1D941F385CE13C8C16A819FE3";
	String acessToken="9B3496BB19FB4CE509F470B3E5D0BDB4";
	String acessSecret="D8E3F5C223A052849DCD2A97014A6730";
	
	@Test
	public void getweatherdetails() {

		RestAssured.baseURI="https://api.trademe.co.nz";
		Response res=RestAssured.given()
				.auth()
				.oauth(consumerKey, consumerSecret, acessToken, acessSecret)
				.when()
				.get("/v1/Search/Motors/Used.json")
				.then().assertThat().statusCode(200).log().all().extract().response(); 
				
				System.out.println(res.statusCode());
	}
}
