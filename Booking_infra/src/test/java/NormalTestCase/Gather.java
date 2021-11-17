package NormalTestCase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


public class Gather {

    static void enterTxt(WebDriver driver, String xpath, String keys) throws InterruptedException {
        driver.findElement(By.xpath(xpath)).sendKeys(keys);
        Actions a=new Actions(driver);
        Thread.sleep(2000);
        a.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
    }


    static Boolean validate_date(WebDriver driver,String date){
        List<WebElement> dis= driver.findElements(By.xpath("//td[@class='bui-calendar__date bui-calendar__date--disabled']"));
        System.out.println(dis.size());
        for(int j=1;j<=dis.size();j++) {
            String s=driver.findElements(By.xpath("//div[@class=\"bui-calendar__main b-a11y-calendar-contrasts\"]//div[@class='bui-calendar__content']//td[@class='bui-calendar__date']")).get(j).getText();
            System.out.println(s);

        }
        return true;
    }

//    static void setdate(WebDriver driver,String date,String date2){
//
////        Boolean iv=validate_date(driver,date);
////        System.out.println(iv);
//        if(true){
//            System.out.println("hi");
//
//            List<WebElement> enb=driver.findElements(By.xpath("//td[@class='bui-calendar__date']"));
//
//            List<WebElement> enablee=driver.findElements(By.xpath("//div[@class=\"bui-calendar__main b-a11y-calendar-contrasts\"]//div[@class='bui-calendar__content']//td[@class='bui-calendar__date']"));
////            System.out.println(enablee);
//            int count=enablee.size();
//            for(int i=1;i<=count;i++)
//            {
//                String text=driver.findElement(By.xpath("//div[@class=\"bui-calendar__main b-a11y-calendar-contrasts\"]//div[@class='bui-calendar__content']//td[@class='bui-calendar__date']["+i+"]")).getText();
//
////                String text=driver.findElement()
//                System.out.println(text);
//                if(text.equalsIgnoreCase(date))
//                {
//                    driver.findElements(By.xpath("td[@class='bui-calendar__date']")).get(i).click();
//                }//
//            }
//            System.out.println(count);
//
//
//
//        }
//
//    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rohit.wagh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.booking.com/");

        enterTxt(driver,"//*[@id=\"ss\"]","Manali");


        List<WebElement> l=driver.findElements(By.xpath("//td//span/span"));

        for(int j=1;j<=l.size();j++){
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


        driver.findElement(By.xpath("//button[@data-sb-id=\"main\"]")).click();

        Thread.sleep(2000);
        List<WebElement> hlist=driver.findElements(By.xpath("//div[@data-testid=\"title\"]"));
        for(WebElement el:hlist){
            System.out.println(el.getText());
        }

        driver.quit();


    }






}
