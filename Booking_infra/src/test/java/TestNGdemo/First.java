package TestNGdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class First {
    WebDriver driver;

    @BeforeMethod
    public void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void Close_Browser(){
        driver.close();
    }

    @Test()
    public void test_search() throws InterruptedException {
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ss\"]")).sendKeys("Manali");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@role='option'][1]")).click();
//        Actions a=new Actions(driver);
//        a.sendKeys(Keys.ARROW_DOWN).build().perform();
        List<WebElement> l=driver.findElements(By.xpath("//td//span/span"));

        for(int j=1;j<l.size();j++){
            String txt=driver.findElements(By.xpath("//td//span/span")).get(j).getText();
//            System.out.println(txt);
            if(txt.equalsIgnoreCase("26"))
            {
                driver.findElements(By.xpath("//td//span/span")).get(j).click();
//                Thread.sleep(800);
//                break;
            }

            if(txt.equalsIgnoreCase("28")){
                driver.findElements(By.xpath("//td//span/span")).get(j).click();
//                Thread.sleep(1000);
                break;
            }

        }

        driver.findElement(By.xpath("//button[@data-sb-id=\"main\"]")).click();

    }



    @Test(priority = 1,dependsOnMethods = {"test_search"})
    public void Fetch_data() throws InterruptedException {

        List<WebElement> hlist=driver.findElements(By.xpath("//div[@data-testid=\"title\"]"));
        System.out.println(hlist.size());
        Thread.sleep(3000);
        Assert.assertEquals(hlist.size(),25);
    }

}
