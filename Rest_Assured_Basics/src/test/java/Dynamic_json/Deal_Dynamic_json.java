package Dynamic_json;

import Dynamic_json.com_files.helper;
import Dynamic_json.com_paths.paths;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Deal_Dynamic_json {
    @Test(dataProvider="BookData")
    public void addBook(String nm,String aisl){
        RestAssured.baseURI="http://216.10.245.166";
        String response = given().header("Content-Type","application/json").
                body(paths.addBookPath(nm,aisl))
                .when()
                .post("Library/Addbook.php")
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .extract().response().asString();
        String id= helper.json_data_filter(response,"ID");
        System.out.println(id);
    }

    @Test(dataProvider = "DeleteBookData")
    public void DeleteBook(String ID){
        RestAssured.baseURI="http://216.10.245.166";
        given().header("Content-Type","application/json").
                body(paths.DeleteBookPath(ID))
                .when().post("/Library/DeleteBook.php").then()
                .log().body()
                .assertThat().statusCode(200).body("msg",equalTo("book is successfully deleted"));
    }

    @DataProvider(name = "BookData")
    public Object[][] getData(){
        return new Object[][] {{"124hjda","21512"},{"fdkjai1k","2910"},{"mhjbkak","219058"}};
    }

    @DataProvider(name="DeleteBookData")
    public Object[][] deleteData(){
        return new Object[][]{{"124hjda21512"},{"fdkjai1k2910"},{"mhjbkak219058"}};
    }
}
