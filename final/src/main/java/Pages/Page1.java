package Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class Page1 extends PageObject {
    @Step
    public void open_url(){
        open();
    }


    @Step
    public void enter_txt(String x) throws InterruptedException {
        typeInto($("//*[@id=\"ss\"]"),x);
        Thread.sleep(3000);
        withAction().click($("//li[@role='option'][1]")).perform();
    }

    @Step
    public void set_date() throws InterruptedException {
        List<WebElementFacade> er=findAll("//td//span/span");

        for(int i=1;i<er.size();i++){
            String txt=findAll("//td//span/span").get(i).getText();
            if(txt.equalsIgnoreCase("24"))
            {
                withAction().click(findAll("//td//span/span").get(i)).perform();
                Thread.sleep(1000);
            }

            if(txt.equalsIgnoreCase("27")){
                withAction().click(findAll("//td//span/span").get(i)).perform();
                break;
            }

        }
    }
    @Step
    public void Search_Btn(){
        withAction().click($("//button[@data-sb-id=\"main\"]")).perform();
    }


}
