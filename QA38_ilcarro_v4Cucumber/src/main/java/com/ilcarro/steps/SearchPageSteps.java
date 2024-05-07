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
        new SearchPage(BasePage.driver, BasePage.wait).enterData("Berlin");
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

    @Given("User click button search!")
    public void clickYalla() {
        new SearchPage(BasePage.driver, BasePage.wait).handleClickSubmitButton();
    }

    @And("User checked success message after search")
    public void checkSuccessMessage() {
        new SearchPage(BasePage.driver, BasePage.wait).checkNoAvailableCarsMessage();
    }
}
