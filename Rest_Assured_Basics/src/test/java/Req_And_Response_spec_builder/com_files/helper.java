package Req_And_Response_spec_builder.com_files;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class helper {
    public static RequestSpecification req_builder(){
        RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key","qaclick123")
                .setContentType(ContentType.JSON).build();
        return req;
    }
    public static ResponseSpecification response_builder(){
        ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
                .build();
        return resp;
    }
}
