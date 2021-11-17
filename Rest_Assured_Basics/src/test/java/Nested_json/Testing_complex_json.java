package Nested_json;

import Nested_json.com_files.helper;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testing_complex_json {
    @Test
    public void get_sum(){
        JsonPath js = helper.jsgiver();
        int course_size=js.getInt("courses.size()");
        int sum=0;
        for(int i=0;i<course_size;i++)
        {
            sum+=js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies");
//            System.out.println(sum);
        }
        Assert.assertEquals(sum,js.getInt("dashboard.purchaseAmount"));

    }
}
