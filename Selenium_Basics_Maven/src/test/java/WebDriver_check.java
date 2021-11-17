import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class WebDriver_check {
    public static void main(String[] args) throws InterruptedException, IOException {
//        GetDriver gd= new GetDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rohit.wagh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.mycontactform.com/samples.php");

        //checkbox
        driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/div/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/div/input[2]")).click();

        //TextBox
        driver.findElement(By.id("subject")).sendKeys("Rohit");

        //radio Button
        driver.findElement(By.xpath("//input[@value=\"Second Option\"]")).click();

        //Drop Down
        WebElement ele=driver.findElement(By.id("q3"));
        Select y=new Select(ele);
        y.selectByVisibleText("Third Option");

        //email
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("abc@gmail.com");

        //submit button
//        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        //ScreenShot

//        driver.
//        TakesScreenshot screenshot=((TakesScreenshot) driver);
//        File source= screenshot.getScreenshotAs(OutputType.FILE);
//
//        FileUtils.copyFile(source,new File("C:\\Users\\rohit.wagh\\IdeaProjects\\Selenium_Basics_Maven\\src\\screenshot\\first.jpg"));

        //Get Multiple links along with screenshot

        driver.findElement(By.partialLinkText("Basic")).click();


        int sz=driver.findElements(By.xpath("//*[@id=\"left_col_top\"]/ul")).size();

        for(int i=1;i<=sz;i++){
            int ssz=driver.findElements(By.xpath("//*[@id=\"left_col_top\"]/ul["+i+"]/li/a")).size();
//            System.out.println(ssz);
            for(int j=1;j<=ssz;j++){
                driver.findElement(By.xpath("//*[@id=\"left_col_top\"]/ul["+i+"]/li["+j+"]/a")).click();
                TakesScreenshot screenshot=((TakesScreenshot) driver);
                File source= screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source,new File("C:\\Users\\rohit.wagh\\IdeaProjects\\Selenium_Basics_Maven\\src\\screenshot\\Section"+i+"img"+j+".jpg"));
            }
        }




//        System.out.println(sz);

        Thread.sleep(3500);

        driver.quit();

    }
}
