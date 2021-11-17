package Pages;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleSerenityPAge extends PageObject {
    public void search_Home() {
        $(By.name("q")).type("2+2");
        $(By.name("btnK")).click();
    }
}
