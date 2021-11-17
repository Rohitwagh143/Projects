package Dynamic_json.com_files;

import io.restassured.path.json.JsonPath;

public class helper {

    public static String json_data_filter(String res,String getter){
        JsonPath js= new JsonPath(res);//for parsing json
        return js.getString(getter);
    }

}
