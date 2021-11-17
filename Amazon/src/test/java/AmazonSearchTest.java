import PageObjects.AmazonSearchpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class AmazonSearchTest {
    //read property file

    WebDriver wdriver;
 @BeforeMethod
 public void setup() throws IOException {
     DriverSetup dr=new DriverSetup();
    wdriver= dr.initializeDriver();
    wdriver.manage().window().maximize();
     /* maximize the window */

    }
    @Test
    public void search() throws IOException {
     AmazonSearchpage test=new AmazonSearchpage(wdriver);
        test.getSearch().sendKeys(ExcelUtil.read_excel());
        Actions act = new Actions(wdriver);
        act.sendKeys(Keys.DOWN, Keys.ENTER).build().perform();
        List<WebElement> headings= test.itemsList();

        System.out.println(headings.size());
        for (WebElement title : headings) {
            System.out.println(title.getText());
        }
    }
    @AfterMethod
    public void tearDown()
    {
        wdriver.close();
    }
}
