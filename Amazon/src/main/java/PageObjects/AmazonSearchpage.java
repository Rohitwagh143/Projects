package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

 public class AmazonSearchpage  {
    public WebDriver driver;

By search=By.xpath("//div[@class='nav-fill']/div/input[@id='twotabsearchtextbox']");
By items=By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//a//span");


     public AmazonSearchpage (WebDriver driver) {
         // TODO Auto-generated constructor stub

         this.driver=driver;

     }
     public WebElement getSearch()
     {

         return driver.findElement(search);
     }
public List<WebElement> itemsList(){
     List<WebElement> itemList = driver.findElements(items);
     return itemList;
}
 }