package Api.endpoints;

//https://petstore.swagger.io/#/user  post
//https://petstore.swagger.io/#/user/{username} get    
//https://petstore.swagger.io/#/user/{username} put
//	https://petstore.swagger.io/#/user/{username} delete
public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";

	// usermodel

	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String update_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";

}
