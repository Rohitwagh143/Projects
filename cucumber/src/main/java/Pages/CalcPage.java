package Pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class CalcPage extends PageObject {
    CalculatorPage calc;


@Step
public void calculate()
{

    calc.calculate();
}

}
