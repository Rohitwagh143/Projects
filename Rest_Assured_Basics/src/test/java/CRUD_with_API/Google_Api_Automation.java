package CRUD_with_API;

import CRUD_with_API.com_files.helper;
import io.restassured.RestAssured;
import CRUD_with_API.com_paths.paths_bodies;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Google_Api_Automation {


    //post method
    public static String add_place(){
        RestAssured.baseURI=helper.url_setup();
        System.out.println("\n\n Post method\n");
        String response1= given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(paths_bodies.adder_req).when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("server","Apache/2.4.18 (Ubuntu)").extract().response().asString();
        System.out.println(response1);
        return helper.json_data_filter(response1,"place_id");

    }

    //put method
    public static void update_place(String place_id){

        RestAssured.baseURI=helper.url_setup();
        System.out.println("\n\n put method\n");
         given().queryParams("key","qaclick123","place_id",place_id).header("Content-Type","application/json")
                .body(paths_bodies.address_body(place_id)).when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
    }


    //get method

    public static void get_address(String place_id){
        RestAssured.baseURI=helper.url_setup();

        System.out.println("\n\n get method\n");
        given().queryParams("key","qaclick123","place_id",place_id).when()
                .get("maps/api/place/get/json").then().
                assertThat().log().all().statusCode(200).body("address",equalTo("Konoha , land of fire 4th Hokage"));
    }

    public static void main(String[] args) {
        String place_id=add_place();
        System.out.println(place_id);
        update_place(place_id);
        get_address(place_id);
    }
}
