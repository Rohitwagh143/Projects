package Deserlization_Pojo.Runner;


import Deserlization_Pojo.Runner.com_files.helper;
import Deserlization_Pojo.Runner.com_files_creds.creds;
import Deserlization_Pojo.Pojo.GetCourse;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.given;

public class OAuth_2_0_With_Pojo {

    public static void main(String[] args) throws InterruptedException {

        //getting the base code
//        String code=helper.get_code();
        String code= creds.code;
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



//        System.out.println("Access token response: "+AccessTokenResponse);
        //getting the actual access token for OAuth 2.0
        String ActualAccessToken= helper.json_data_filter(AccessTokenResponse,"access_token");

//        System.out.println(ActualAccessToken);

        //requesting with OAuth 2.0 access token
        GetCourse gc = given().queryParam("access_token", ActualAccessToken).expect().defaultParser(Parser.JSON)
                .when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
//        System.out.println(response);

        System.out.println(gc.getLinkedIn());
        System.out.println(gc.getInstructor());

        System.out.println(gc.getServices());
        System.out.println(gc.getExpertise());
        System.out.println(gc.getUrl());

        helper.print_course_details(gc.getCourses(),"api","void");
        helper.print_course_details(gc.getCourses(),"webautomation", "void");
        helper.print_course_details(gc.getCourses(),"mobile","void");

        helper.Assert_check(gc.getCourses(),"webautomation");
        helper.Assert_check(gc.getCourses(),"mobile");
        helper.Assert_check(gc.getCourses(),"api");

//        System.out.println(gc.getServices());

    }
}
