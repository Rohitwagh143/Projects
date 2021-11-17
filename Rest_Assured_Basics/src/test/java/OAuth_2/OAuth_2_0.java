package OAuth_2;

import OAuth_2.com_files.helper;
import OAuth_2.com_files_creds.creds;

import static io.restassured.RestAssured.given;

public class OAuth_2_0 {
    public static void main(String[] args) throws InterruptedException {

        //getting the base code
//        String code=helper.get_code();
        String code=creds.code;
//        System.out.println(code);

        //getting the AccessTokenResponse
        String AccessTokenResponse=given()
                .urlEncodingEnabled(false)
                .queryParams("code",code)
                //to just make sure that all special characters are not encoded !
                .queryParams("client_id", creds.client_id)
                .queryParams("client_secret",creds.client_secret)
                .queryParams("redirect_uri",creds.redirect_url)
                .queryParams("grant_type",creds.grant_type)
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token").asString();



        System.out.println("Access token response: "+AccessTokenResponse);
        //getting the actual access token for OAuth 2.0
        String ActualAccessToken= helper.json_data_filter(AccessTokenResponse,"access_token");

        System.out.println(ActualAccessToken);

        //requesting with OAuth 2.0 access token
        String response = given().queryParam("access_token", ActualAccessToken).
                when().get("https://rahulshettyacademy.com/getCourse.php").asString();
        System.out.println(response);

    }
}
