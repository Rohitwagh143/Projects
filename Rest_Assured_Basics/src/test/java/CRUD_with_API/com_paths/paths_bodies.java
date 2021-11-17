package CRUD_with_API.com_paths;

public class paths_bodies {
    public static String adder_req="{\n" +
            "  \"location\": {\n" +
            "    \"lat\": -19.383494,\n" +
            "    \"lng\": 39.427362\n" +
            "  },\n" +
            "  \"accuracy\": 10,\n" +
            "  \"name\": \"Akash\",\n" +
            "  \"phone_number\": \"(+91) 983 777 7777\",\n" +
            "  \"address\": \"29, side layout, fire 09\",\n" +
            "  \"types\": [\n" +
            "    \"tie shop\",\n" +
            "    \"computer\"\n" +
            "  ],\n" +
            "  \"website\": \"http://google.com\",\n" +
            "  \"language\": \"French-IN\"\n" +
            "}\n";


    public static String address_body(String place_id){
        return "{\n" +
            "\"place_id\":\""+place_id+"\",\n" +
            "\"address\":\"Konoha , land of fire 4th Hokage\",\n" +
            "\"key\":\"qaclick123\"\n" +
            "}";}

}
