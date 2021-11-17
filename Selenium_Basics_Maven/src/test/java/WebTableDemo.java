import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rohit.wagh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();


        driver.get("http://demo.guru99.com/test/web-table-element.php");

        int row=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr")).size();
        for(int i=1;i<=row;i++){
            int col=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td")).size();
            for(int j=1;j<=col;j++){
                String s=driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.println(s);

            }
            System.out.println("\n");

        }
    }
}
