package Serelize_Pojo;

import Serelize_Pojo.Pojo.pojo_class;
import Serelize_Pojo.Pojo.sub_Pojo.location;
import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class serialize_Test {
    public static void main(String[] args) {
        pojo_class p=new pojo_class();
        p.setAccuracy(90);
        p.setName("Boston tea party center");
        p.setPhone_number("(+91) 798 123 4567");
        p.setAddress("At post disk break , new jours final");
        p.setLanguage("Polish");
        p.setWebsite("https://rohitshetty.com");
        List<String> mylist= new ArrayList<>();
        mylist.add("new place");
        mylist.add("old place");

        p.setTypes(mylist);

        location l=new location();
        l.setLat(-29.123512);
        l.setLng(90.12492);
        p.setLocation(l);


        RestAssured.baseURI="https://rahulshettyacademy.com";
        String response=given().log().all().queryParam("key","qaclick").body(p)
                .when().log().body().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(response);
    }
}
