import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascriptexe {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rohit.wagh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.linkedin.com/");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.getElementById('session_key').value='waghrohit@gmail.com';");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('session_password').value='password';");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/button")).click();
//        driver.findElement(By.className("VfPpkd-vQzf8d")).click();
//        js.executeScript("document.getElementByClassName('VfPpkd-vQzf8d').click();");//class="VfPpkd-vQzf8d"

        driver.quit();
    }
}
