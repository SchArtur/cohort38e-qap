package com.ilcarro.steps;

import com.ilcarro.pages.BasePage;
import com.ilcarro.pages.HomePage;
import com.ilcarro.pages.LetTheCarWorkPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LetTheCarWorkSteps {
    @Given("User click Let the car work link")
    public void clickLetTheCarWorkLink() {
        new HomePage(BasePage.driver, BasePage.wait).clickOnCarWorkLink();
    }

    @When("User enter address \"(.+)\", manufacture \"(.+)\", model \"(.+)\", year \"(.+)\", seats \"(.+)\", carClass \"(.+)\", registrationNumber \"(.+)\", and price \"(.+)\"$")
    public void enterEmailAndPassword(String address, String manufacture, String model, String year, String seats, String carClass, String registrationNumber, String price) {
        new LetTheCarWorkPage(BasePage.driver, BasePage.wait).enterData(address, manufacture, model, year, seats, carClass, registrationNumber, price);
    }

    @When("User enter address, manufacture, model, year, seats, carClass, registrationNumber, and price as data")
    public void enterEmailAndPasswordAsData(DataTable table) {
        new LetTheCarWorkPage(BasePage.driver, BasePage.wait).enterData(table);
    }

    @When("User enter address, manufacture, model, year, seats, carClass, registrationNumber and price ")
    public void enterValidEmailAndPassword() {
        new LetTheCarWorkPage(BasePage.driver, BasePage.wait).enterData("Amsterdam Airport Schiphol (AMS), Aankomstpassage, Schiphol, Netherlands", "Germany", "Audi RS8", "2022", "2", "passenger сar", "D2JYJ6WFOG", "900");
    }

    @Given("User click fuel")
    public void clickFuel() {
        new LetTheCarWorkPage(BasePage.driver, BasePage.wait).handlerClickFuel();
    }

    @Given("User choose option petrol in fuel dropdown")
    public void choosePetrol() {
        new LetTheCarWorkPage(BasePage.driver, BasePage.wait).chooseDropDownFuel();
    }

    @Given("User fill about")
    public void fillAbout() {
        new LetTheCarWorkPage(BasePage.driver, BasePage.wait).fillAboutArea();
    }

    @Given("User add photo")
    public void clickPhoto() {
        new LetTheCarWorkPage(BasePage.driver, BasePage.wait).addPhoto();
    }

    @Given("User click button Submit")
    public void clickSubmit() {
        new LetTheCarWorkPage(BasePage.driver, BasePage.wait).handlerClickButtonSubmit();
    }

    @Given("User click button Ok")
    public void clickButtonOk() {
        new LetTheCarWorkPage(BasePage.driver, BasePage.wait).handleClickButtonOk();
    }

    @And("User checked unsuccessful message after submit")
    public void checkSuccessMessage() {
        new LetTheCarWorkPage(BasePage.driver, BasePage.wait).isUnSuccessCarToRent();
    }
}
