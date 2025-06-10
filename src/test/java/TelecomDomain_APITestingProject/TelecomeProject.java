package TelecomDomain_APITestingProject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

/*
 * given():Precondition
 * ====================
 * header,cookie,request payload,query and path parameters,authentication
 * 
 * when(): Action-sending request to server
 * =====================================
 * GET,POST,PUT,PATCH,DELETE
 * 
 * then():Response validation
 * =========================
 * status code,message,response time,response payload
 * 
 */

public class TelecomeProject {
	String userToken;

	@Test(priority = 1)
	public void addNewUser() {
		System.out.println("--------------------------addNewUser--Test1-----------------------------");
		String emailid = "ashwin" + System.currentTimeMillis() + "@gmail.com";

		// request payload
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("firstName", "Ashwin");
		data.put("lastName", "Rao");
		data.put("email", emailid);
		data.put("password", "test123");

		Response res = given()
				.header("Content-Type", "application/json")
				.header("accept", "application/json")
				.body(data)
				.when().post("https://thinking-tester-contact-list.herokuapp.com/users");

		// validation
		Assert.assertEquals(res.statusCode(), 201);
		System.out.println("New User Added!");
		res.then().log().body();

		// get the token and store in a variable
		userToken = res.jsonPath().getString("token");
		System.out.println("Token is " + userToken);
		System.out.println("Test 1 Add User Profile  pass!");
	}

	@Test(priority = 2, dependsOnMethods = "addNewUser")
	public void getUserProfile() {

		System.out.println("---------------------------getUserProfile--Test2--------------------------");
		Response res = given()
				.header("Content-Type", "application/json")
				.header("accept", "application/json")
				.header("Authorization", "Bearer " + userToken)
				.when().get("https://thinking-tester-contact-list.herokuapp.com/users/me");
		res.then().log().body();

		// validation
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println("Test 2 User Details pass!");

	}

	@Test(priority = 3, dependsOnMethods = "addNewUser")
	public void updateUser() {
		System.out.println("----updateUser--Test3---------");
		
		// payload
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("firstName", "Ashwin");
		data.put("lastName", "Mehra");

		Response res = given()
				.header("Content-Type", "application/json")
				.header("accept", "application/json")
				.header("Authorization", "Bearer " + userToken)
				.body(data)
				.when().patch("https://thinking-tester-contact-list.herokuapp.com/users/me");
		res.then().log().body();

		// validation
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println("Test 3 updateUser pass!");

	}

	String loginToken;
	String id;

	@Test(priority = 4)
	public void logInUser() {
		System.out.println("-------------------------logInUser--Test4---------------------------");
		// request payload
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("email", "ashwin@gmail.com");
		data.put("password", "test123");

		Response res = given()
				.header("Content-Type", "application/json")
				.header("accept", "application/json")
				.body(data)
				.when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");

		// validation
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println("Login Don Successfully !");

		// get the token and store in a variable
		loginToken = res.jsonPath().getString("token");
		System.out.println("Token is " + loginToken);
		System.out.println("Test 4 Login User pass!");
	}

	@Test(priority = 5, dependsOnMethods = "logInUser")
	public void addContact() {
		System.out.println("---------------------------addContact--Test5-------------------------");
		// request payload
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("firstName", "John");
		data.put("lastName", "Doe");
		data.put("birthdate", "1970-01-01");
		data.put("email", "jdoe@gmail.com");
		data.put("phone", "8005555555");
		data.put("street1", "1 Main St.");
		data.put("street2", "Apartment A");
		data.put("city", "Anytown");
		data.put("stateProvince", "KS");
		data.put("postalCode", "12345");
		data.put("country", "USA");

		Response res = given()
				.header("Content-Type", "application/json")
				.header("accept", "application/json")
				.header("Authorization", "Bearer " + loginToken).body(data)
				.when().post("https://thinking-tester-contact-list.herokuapp.com/contacts");

		// validation
		Assert.assertEquals(res.statusCode(), 201);
		System.out.println("New User Added!");
		res.then().log().body();

		// get the token and store in a variable
		id = res.jsonPath().getString("_id");
		System.out.println("ID is " + id);
		System.out.println("Test 5 Add Contact   pass!");
	}

	@Test(priority = 6, dependsOnMethods = "logInUser")
	public void getContactList() {
		System.out.println("-----------------------getContactList--Test6----------------------");
		Response res = given()
				.header("Content-Type", "application/json")
				.header("accept", "application/json")
				.header("Authorization", "Bearer " + loginToken)
				.when().get("https://thinking-tester-contact-list.herokuapp.com/contacts");
		res.then().log().body();

		// validation
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println("ID is " + id);
		System.out.println("Test 6 Get Contact List pass!");

	}

	@Test(priority = 7, dependsOnMethods = "logInUser")
	public void getContact() {
		System.out.println("--------------------getContact--Test7----------------------");
		Response res = given().header("Content-Type", "application/json")
				.header("accept", "application/json")
				.header("Authorization", "Bearer " + loginToken)
				.when().get("https://thinking-tester-contact-list.herokuapp.com/contacts/" + id);
		res.then().log().body();

		// validation
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println("Test 7 Get Contact  pass!" + id);

	}

	@Test(priority = 8, dependsOnMethods = "logInUser")
	public void updateContact() {
		System.out.println("-----------------------updateContact--Test8-------------------");
		// request payload
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("firstName", "Amy");
		data.put("lastName", "Miller");
		data.put("birthdate", "1992-02-02");
		data.put("email", "amiller@gmail.com");
		data.put("phone", "8005554242");
		data.put("street1", "13 School St.");
		data.put("street2", "Apt. 5");
		data.put("city", "Washington");
		data.put("stateProvince", "QC");
		data.put("postalCode", "A1A1A1");
		data.put("country", "Canada");

		Response res = given()
				.header("Content-Type", "application/json")
				.header("accept", "application/json")
				.header("Authorization", "Bearer " + loginToken).header("Cookie", "token={{logintoken}}").body(data)
				.when().put("https://thinking-tester-contact-list.herokuapp.com/contacts/" + id);
		res.then().log().body();

		// validation
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println(" User Updated! with ID    :" + id);

		System.out.println("Test 8 Update Contact   pass!");
	}

	@Test(priority = 9, dependsOnMethods = "logInUser")
	public void patchUpdateContact() {

		System.out.println("-----------------updateContact--Test9-----------------------------");
		// request payload
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("firstName", "Anna");

		Response res = given()
				.header("Content-Type", "application/json")
				.header("accept", "application/json")
				.header("Authorization", "Bearer " + loginToken)
				.header("Cookie", "token={{logintoken}}").body(data)
				.when().patch("https://thinking-tester-contact-list.herokuapp.com/contacts/" + id);
		res.then().log().body();

		// validation
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println(" User Updated! with ID    :" + id);
		System.out.println("Test 9 Update Contact   pass!");

	}

	@Test(priority = 10, dependsOnMethods = "logInUser")
	public void logoutUser() {

		System.out.println("-----------------updateContact--Test10-----------------------------");
		Response res = given().header("Content-Type", "application/json").header("accept", "application/json")
				.header("Authorization", "Bearer " + loginToken).when()
				.post("https://thinking-tester-contact-list.herokuapp.com/users/logout");

		// validation
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println("Assertion passed!");
		System.out.println("Test 10 Log OUT  pass!");

	}

}
