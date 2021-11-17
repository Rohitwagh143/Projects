package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class B_Setup {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
            driver = new ChromeDriver();
            driver.get(prop.getProperty("url"));

        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox"));
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {

        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }

}
