package TestCases;



import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)



public class test_1 extends PageObject{

    @Managed
    WebDriver driver;

    @Test
    public void test(){
        driver.get("https://www.booking.com/");
//        open();
//        driver.get("https://www.booking.com/");

    }


}
