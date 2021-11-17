package Pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class GooglePage extends PageObject
{
      GoogleSerenityPAge testpage;

   @Step
        public void  openApplication() {
        open();

   }

       @Step
       public void enter_search_keyword()
       {
               testpage.search_Home();

        }



}
