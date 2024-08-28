package Api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Api.endpoints.Userendpoints;
import Api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;

	@BeforeMethod
	public void setupData() {

		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

	}

	@Test(priority = 1)
	public void testPostUser() {

		Response response = Userendpoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void testGetUser() {
		
	
		Response response = Userendpoints.readUser("string");
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response = Userendpoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority = 4)
	public void testDeleteUser() {
		
		Response response = Userendpoints.deleteUser("string");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	
	}
}
