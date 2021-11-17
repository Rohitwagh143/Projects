package Dynamic_json.com_paths;

public class paths {
    public static String addBookPath(String isbn,String aisle){
        return "{\n" +
            "\"name\":\"Python with AIML\",\n" +
            "\"isbn\":\""+isbn+"\",\n" +
            "\"aisle\":\""+aisle+"\",\n" +
            "\"author\":\"Rohit_wagh\"\n" +
            "}\n";}

    public static String DeleteBookPath(String id){
        return "{\n" +
                "\"ID\" : \""+id+"\"\n" +
                "} \n";
    }
}
