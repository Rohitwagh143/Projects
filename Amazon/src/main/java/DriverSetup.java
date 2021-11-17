import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DriverSetup {


        public WebDriver driver;
        public Properties prop;

        public WebDriver initializeDriver() throws IOException {

            prop = new Properties();
            FileInputStream fis = new FileInputStream("D:\\bootomline_Selenium\\Amazon\\config.properties");

            prop.load(fis);
            String browserName = prop.getProperty("browser");
            System.out.println(browserName);

            if(browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
                driver = new ChromeDriver();
                driver.get(prop.getProperty("url"));
                //execute in chrome driver

            } else if (browserName.equals("firefox")) {
                driver = new FirefoxDriver();
                //firefox code
            } else if (browserName.equals("IE")) {
//	IE code
            }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver;


        }

        public void getScreenshot(String result) throws IOException {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));

        }


    }
