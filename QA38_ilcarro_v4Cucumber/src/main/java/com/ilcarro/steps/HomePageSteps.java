package com.ilcarro.steps;

import com.ilcarro.pages.BasePage;
import com.ilcarro.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

    @Given("User launch Chrome browser")
    public void openBrowser() {
        new HomePage(BasePage.driver, BasePage.wait).openBrowserInPage();
    }

    @When("User open ilcarro Home Page")
    public void openHomePage() {
        new HomePage(BasePage.driver, BasePage.wait).openUrl();
    }

    @Then("User checked Home Page title is displayed")
    public void checkTitle() {
        new HomePage(BasePage.driver, BasePage.wait).isHomePageTitlePreset();
    }

    @And("User quites browser")
    public void quitDriver() {
        new HomePage(BasePage.driver, BasePage.wait).closeBrowser();
    }
}
