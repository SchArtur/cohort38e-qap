package com.ilcarro.pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @FindBy(xpath = "//input[@id = 'city']")
    WebElement inputCity;

    @FindBy(xpath = "//span[text() = 'Israel']")
    WebElement dropDownCity;

    @FindBy(xpath = "//input[@id = 'dates']")
    WebElement inputDates;

    @FindBy(css = ".car-card")
    WebElement carCard;

    @FindBy(xpath = "//button[text() = 'Y’alla!']")
    WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(), '21')]")
        WebElement startDate;

    @FindBy(xpath = "//div[contains(text(), '24')]")
    WebElement endDate;

    public SearchPage handleClickSubmitButtonYalla() {
        clickOnElement(submitButton);
        return this;
    }

    public SearchPage handleClickDropDownCity() {
        clickOnElement(dropDownCity);
        return this;
    }

    public SearchPage handleClickDatePicker() {
        clickOnElement(inputDates);
        return this;
    }

    public SearchPage checkAvailableCars() {
        boolean isCarCardDisplayed = carCard.isDisplayed();
        Assert.assertTrue("Car card is not displayed.", isCarCardDisplayed);
        return this;
    }

    public SearchPage enterData(String city) {
        fillInputField(inputCity, city);
        return this;
    }

    public SearchPage enterData(DataTable table) {
        List<Map<String, String>> dataTableList = table.asMaps();
        return enterData(dataTableList.get(0).get("city"));
    }

    public SearchPage clickOnDatesInDatePicker() {
        clickOnElement(startDate);
        clickOnElement(endDate);
        return this;
    }
}
