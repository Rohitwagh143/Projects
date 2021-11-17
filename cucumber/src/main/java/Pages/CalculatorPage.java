package Pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalculatorPage extends PageObject {
    public void calculate()
    {
 String result=$(By.id("cwos")).getText();


        Assert.assertEquals(result, "4");

       getDriver().close();
    }

}
