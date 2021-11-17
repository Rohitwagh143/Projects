package Req_And_Response_spec_builder;

import Req_And_Response_spec_builder.com_files.helper;
import Serelize_Pojo.Pojo.pojo_class;
import Serelize_Pojo.Pojo.sub_Pojo.location;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Tester {
    public static void main(String[] args) {
        pojo_class p=new pojo_class();
        p.setAccuracy(90);
        p.setName("Bahama ,xyz");
        p.setPhone_number("(+91) 128 123 4567");
        p.setAddress("At post disk break , new jours final");
        p.setLanguage("Polish");
        p.setWebsite("https://rohit.com");
        List<String> mylist= new ArrayList<>();
        mylist.add("this place");
        mylist.add("that place");

        p.setTypes(mylist);

        location l=new location();
        l.setLat(18.123512);
        l.setLng(36.12492);
        p.setLocation(l);


        //Making request with the request spec builder
        RequestSpecification res =given().spec(helper.req_builder()).body(p);

        //Checking the response with response spec builder
        String response = res.when().log().body().post("maps/api/place/add/json")
                .then()
                .spec(helper.response_builder())
                .extract().response().asString();
        System.out.println(response);


    }
}
