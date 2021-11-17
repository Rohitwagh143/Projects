package Nested_json.com_files;


import Nested_json.com_path_bodies.paths_bodies;
import io.restassured.path.json.JsonPath;

public class helper {

    public static JsonPath jsgiver(){
        return new JsonPath(paths_bodies.nested_json);
    }

}
