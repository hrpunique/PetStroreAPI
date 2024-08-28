package Api.test;



import org.testng.Assert;
import org.testng.annotations.Test;

import Api.endpoints.Userendpoints;
import Api.payload.User;
import Api.utilities.Dataproviders;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = Dataproviders.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String useremail, String pwd,
			String ph) {

		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		Response response = Userendpoints.createUser(userPayload);

		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=Dataproviders.class)
	public void testDeleteUserByName(String userName) {
		
		Response response = Userendpoints.deleteUser(userName);
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
