package com.ilcarro.steps;

import com.ilcarro.pages.BasePage;
import com.ilcarro.pages.HomePage;
import com.ilcarro.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class LoginSteps {

    @Given("User click Log in link")
    public void clickLoginLink() {
        new HomePage(BasePage.driver, BasePage.wait).clickOnLoginLink();
    }

    @When("User enter email \"(.+)\", and password  \"(.+)\"$")
    public void enterEmailAndPassword(String email, String password) {
        new LoginPage(BasePage.driver, BasePage.wait).enterData(email, password);
    }

    @When("User enter email, and password as data")
    public void enterEmailAndPasswordAsData(DataTable table) {
        new LoginPage(BasePage.driver, BasePage.wait).enterData(table);
    }

    @When("User enter email and password")
    public void enterValidEmailAndPassword() {
        new LoginPage(BasePage.driver, BasePage.wait).enterData("neuer+1@gm.com", "Manuel1234!");
    }

    @Given("User click Y'alla!")
    public void clickYalla() {
        new LoginPage(BasePage.driver, BasePage.wait).clickSubmitButton();
    }

    @And("User checked success message after login")
    public void checkSuccessMessage() {
        new LoginPage(BasePage.driver, BasePage.wait).isSuccessLogin();
    }

    @And("User checked incorrect message after login")
    public void checkIncorrectMessage() {
        new LoginPage(BasePage.driver, BasePage.wait).isIncorrectLogin();
    }
}
