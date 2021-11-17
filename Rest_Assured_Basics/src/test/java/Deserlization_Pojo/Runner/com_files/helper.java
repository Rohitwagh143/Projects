package Deserlization_Pojo.Runner.com_files;

import OAuth_2.com_files_creds.creds;
import Deserlization_Pojo.Pojo.SubPojo.courses;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class helper {
    public static String json_data_filter(String res, String getter) {
        JsonPath js = new JsonPath(res);//for parsing json
        return js.getString(getter);
    }

    private static String password() {


        return "";


    }

    private static String email() {


        return "waghrohit.j.u@gmail.com";


    }

    private static String url() {


        return "https://accounts.google.com/o/oauth2/v2/auth/identifier?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&flowName=GeneralOAuthFlow";


    }

    public static String hit_url() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/OAuth_2/Resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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
        String url = creds.url;
//        String url=hit_url();
        String partial_url = url.split("code=")[1];
        return partial_url.split("&scope")[0];
    }

    public static <Any> Any print_course_details(courses c, String coursename, String returntype)
    {
        if (returntype.equalsIgnoreCase("void")) {
            if (coursename.equalsIgnoreCase("api")) {
                System.out.println("----------------------- API Course -----------------------");
                for (int i = 0; i < c.getAPI().size(); i++) {
                    System.out.println("Title: " + c.getAPI().get(i).getCourseTitle());
                    System.out.println("Price: " + c.getAPI().get(i).getPrice());
                    System.out.println("----------------------------------------------------------");
                }
            } else if (coursename.equalsIgnoreCase("webautomation")) {

                System.out.println("----------------------- WebAutomation Course -----------------------");
                for (int i = 0; i < c.getWebAutomation().size(); i++) {
                    System.out.println("Title: " + c.getWebAutomation().get(i).getCourseTitle());
                    System.out.println("Price: " + c.getWebAutomation().get(i).getPrice());
                    System.out.println("----------------------------------------------------------");
                }
            } else if (coursename.equalsIgnoreCase("mobile")) {
                System.out.println("----------------------- Mobile Course -----------------------");
//            System.out.println(c.getMobile().size());
                for (int i = 0; i < c.getMobile().size(); i++) {
                    System.out.println("Title: " + c.getMobile().get(i).getCourseTitle());
                    System.out.println("Price: " + c.getMobile().get(i).getPrice());
                    System.out.println("----------------------------------------------------------");

                }

            }
            return null;
        }

        else if(returntype.equalsIgnoreCase("list"))
        {
            ArrayList<String> title = new ArrayList<>();

            if (coursename.equalsIgnoreCase("api")) {
                for (int i = 0; i < c.getAPI().size(); i++) {
                    title.add(c.getAPI().get(i).getCourseTitle());
                }
            } else if (coursename.equalsIgnoreCase("webautomation")) {
                for (int i = 0; i < c.getWebAutomation().size(); i++) {
                    title.add(c.getWebAutomation().get(i).getCourseTitle());
                }
            } else if (coursename.equalsIgnoreCase("mobile")) {
                for (int i = 0; i < c.getMobile().size(); i++) {
                    title.add(c.getMobile().get(i).getCourseTitle());
                }

            }
            return (Any) title;
        }
        return null;
    }


    public static void Assert_check (courses c, String courseName)
    {
        List<String> WebAutomationTitle = Arrays.asList("Selenium Webdriver Java", "Cypress", "Protractor");
        List<String> api = Arrays.asList("Rest Assured Automation using Java", "SoapUI Webservices testing");
        List<String> mobile =Arrays.asList("Appium-Mobile Automation using Java");

        if(courseName.equalsIgnoreCase("webautomation")) {
            List<String> actualTitle = print_course_details(c, courseName, "list");
            Assert.assertTrue(actualTitle.equals(WebAutomationTitle));
        }
        else if(courseName.equalsIgnoreCase("api")){
            List<String> actualTitle = print_course_details(c, courseName, "list");
            Assert.assertTrue(actualTitle.equals(api));
        }

        else if(courseName.equalsIgnoreCase("mobile")){
            List<String> actualTitle = print_course_details(c, courseName, "list");
            Assert.assertTrue(actualTitle.equals(mobile));
        }
//        System.out.println(actualTitle.size());
//        for(String i: actualTitle){
//            System.out.println(i);
//        }

    }
}