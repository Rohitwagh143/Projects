package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class steps {

    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
    }


    @Given("Open the booking.com")
    public void open_the_booking_com(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.booking.com/");
//        throw new io.cucumber.java.PendingException();
    }

    @When("^I Search for (.*) in search Box$")
    public void i_search_for_hotel_in_search_box() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"ss\"]")).sendKeys("Manali");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@role='option'][1]")).click();
        List<WebElement> l=driver.findElements(By.xpath("//td//span/span"));

        for(int j=1;j<l.size();j++){
            String txt=driver.findElements(By.xpath("//td//span/span")).get(j).getText();
//            System.out.println(txt);
            if(txt.equalsIgnoreCase("25"))
            {
                driver.findElements(By.xpath("//td//span/span")).get(j).click();
            }

            if(txt.equalsIgnoreCase("28")){
                driver.findElements(By.xpath("//td//span/span")).get(j).click();
                break;
            }

        }

        driver.findElement(By.xpath("//button[@data-sb-id=\"main\"]")).click();
//        throw new io.cucumber.java.PendingException();

    }

    @Then("Show me the result (.*)")
    public void show_me_the_result(int x){

        List<WebElement> hlist=driver.findElements(By.xpath("//div[@data-testid=\"title\"]"));



    }



    @After
    public void close_setup(){
        driver.quit();
    }
}
