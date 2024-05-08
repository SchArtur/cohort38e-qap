package com.ilcarro.steps;

import com.ilcarro.pages.BasePage;
import com.ilcarro.pages.SearchPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SearchPageSteps {
    @When("User enter city \"(.+)\"$")
    public void enterCity(String city) {
        new SearchPage(BasePage.driver, BasePage.wait).enterData(city);
    }

    @When("User enter city as data")
    public void enterCityAsData(DataTable table) {
        new SearchPage(BasePage.driver, BasePage.wait).enterData(table);
    }

    @When("User enter city")
    public void enterValidCity() {
        new SearchPage(BasePage.driver, BasePage.wait).enterData("Haifa");
    }

    @When("User click on dropdown with name of city")
    public void clickOnDropDownWithCity() {
        new SearchPage(BasePage.driver, BasePage.wait).handleClickDropDownCity();
    }

    @Given("User click on datePicker")
    public void clickDatePicker() {
        new SearchPage(BasePage.driver, BasePage.wait).handleClickDatePicker();
    }

    @Given("User click on dates in datePicker")
    public void clickDates() {
        new SearchPage(BasePage.driver, BasePage.wait).clickOnDatesInDatePicker();
    }

    @Given("User click button Yalla!")
    public void clickYalla() {
        new SearchPage(BasePage.driver, BasePage.wait).handleClickSubmitButtonYalla();
    }

    @And("User checked success adding car after search")
    public void checkSuccessAddCar() {
        new SearchPage(BasePage.driver, BasePage.wait).checkAvailableCars();
    }
}
