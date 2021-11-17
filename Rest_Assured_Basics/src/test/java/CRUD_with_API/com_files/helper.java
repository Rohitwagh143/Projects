package CRUD_with_API.com_files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class helper {

    public static String url_setup(){
        return RestAssured.baseURI="https://rahulshettyacademy.com";
    }



//    public static String adder_req(){
//        return "{\n" +
//                "  \"location\": {\n" +
//                "    \"lat\": -19.383494,\n" +
//                "    \"lng\": 39.427362\n" +
//                "  },\n" +
//                "  \"accuracy\": 10,\n" +
//                "  \"name\": \"Akash\",\n" +
//                "  \"phone_number\": \"(+91) 983 777 7777\",\n" +
//                "  \"address\": \"29, side layout, fire 09\",\n" +
//                "  \"types\": [\n" +
//                "    \"tie shop\",\n" +
//                "    \"computer\"\n" +
//                "  ],\n" +
//                "  \"website\": \"http://google.com\",\n" +
//                "  \"language\": \"French-IN\"\n" +
//                "}\n";
//    }



    public static String json_data_filter(String res,String getter){
        JsonPath js= new JsonPath(res);//for parsing json
        return js.getString(getter);

    }

}
