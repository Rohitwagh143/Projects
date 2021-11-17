package OAuth_2.com_files;

import OAuth_2.com_files_creds.creds;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class helper {
    public static String json_data_filter(String res,String getter){
        JsonPath js= new JsonPath(res);//for parsing json
        return js.getString(getter);
    }

    private static String password(){








        return "";








    }

    private static String email(){



        return "waghrohit.j.u@gmail.com";






    }

    private static String url(){


        return "https://accounts.google.com/o/oauth2/v2/auth/identifier?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&flowName=GeneralOAuthFlow";


    }

    public static String hit_url() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/java/OAuth_2/Resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get(url());
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(email());
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password());
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        return driver.getCurrentUrl();

    }

    public static String get_code() throws InterruptedException {
        String url= creds.url;
//        String url=hit_url();
        String partial_url=url.split("code=")[1];
        return partial_url.split("&scope")[0];
    }
}
