package StepDefinitions;

import Pages.CalcPage;
import Pages.GooglePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
public class stepDefinitions {
    protected WebDriver driver;

@Steps
GooglePage google;

@Steps
CalcPage calc;

    @Given("I open Google")
    public void I_open_google() {
google.openApplication();

    }

    @When("^I enter in search textbox$")

    public void I_enter_in_search_textbox() {
google.enter_search_keyword();
    }

    @Then("^I should get result$")
    public void I_should_get_correct_result() {
calc.calculate();

    }


}

