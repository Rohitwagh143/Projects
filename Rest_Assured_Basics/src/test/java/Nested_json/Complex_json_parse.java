package Nested_json;

import Nested_json.com_files.helper;
import io.restassured.path.json.JsonPath;

public class Complex_json_parse {
    public static void main(String[] args) {
        JsonPath js = helper.jsgiver();

        //printing the number of courses
        int course_size=js.getInt("courses.size()");
        System.out.println(course_size);

        //printing the total purchase amount
        int purchase_amount=js.getInt("dashboard.purchaseAmount");
        System.out.println(purchase_amount);

        //printing the first title of the course
        System.out.println(js.getString("courses[0].title"));

//        4. Print All course titles and their respective Prices
        for (int i=0;i<course_size;i++){
            System.out.println("Course: "+js.getString("courses["+i+"].title")+" Prize: "+js.getInt("courses["+i+"].price"));
        }

//        5. Print no of copies sold by RPA Course

        for(int i=0;i<course_size;i++)
        {
            String c_Title=js.get("courses["+i+"].title");
            if(c_Title.equalsIgnoreCase("RPA")){
                System.out.println(js.get("courses["+i+"].copies").toString());
                break;
            }
        }



//        6. Verify if Sum of all Course prices matches with Purchase Amount
        int sum=0;
        for(int i=0;i<course_size;i++)
        {
            sum+=js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies");
        }
        System.out.println(sum);
    }

}
