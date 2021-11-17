package TestNGdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Second {
    WebDriver driver;



    @BeforeMethod
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rohit.wagh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void Close_Browser(){
        driver.close();
    }

    @Test()
    public void test_search() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"ss\"]")).sendKeys("Manali");
        Actions a=new Actions(driver);
        Thread.sleep(500);
        a.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
    }

    @Test(priority = 1)
    public void Test_date(){
        List<WebElement> l=driver.findElements(By.xpath("//td//span/span"));

        for(int j=1;j<l.size();j++){
            String txt=driver.findElements(By.xpath("//td//span/span")).get(j).getText();
//            System.out.println(txt);
            if(txt.equalsIgnoreCase("20"))
            {
                driver.findElements(By.xpath("//td//span/span")).get(j).click();
//                break;
            }

            if(txt.equalsIgnoreCase("25")){
                driver.findElements(By.xpath("//td//span/span")).get(j).click();
                break;
            }

        }
    }

    @Test(priority = 2,dependsOnMethods = {"test_search","Test_date"})
    public void Search_Button() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-sb-id=\"main\"]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 3,dependsOnMethods = {"Search_Button"})
    public void Fetch_data(){
        List<WebElement> hlist=driver.findElements(By.xpath("//div[@data-testid=\"title\"]"));
        for(WebElement el:hlist){
            System.out.println(el.getText());
        }
    }

}
