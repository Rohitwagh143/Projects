package Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class Page2 extends PageObject {
    @Step
    public int second_page(){
        List<WebElementFacade> hlist=findAll("//div[@data-testid=\"title\"]");
        return hlist.size();
    }
}
