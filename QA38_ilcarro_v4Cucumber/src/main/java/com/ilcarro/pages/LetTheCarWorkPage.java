package com.ilcarro.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class LetTheCarWorkPage extends BasePage {
    public LetTheCarWorkPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//input[@id = 'pickUpPlace']")
    WebElement addressInput;

    @FindBy(xpath = "//input[@id = 'make']")
    WebElement manufactureInput;

    @FindBy(xpath = "//input[@id = 'model']")
    WebElement modelInput;

    @FindBy(xpath = "//input[@id = 'year']")
    WebElement yearInput;

    @FindBy(xpath = "//select[@id = 'fuel']")
    WebElement fuelInput;

    @FindBy(xpath = "//input[@id = 'seats']")
    WebElement seatsInput;

    @FindBy(xpath = "//input[@id = 'class']")
    WebElement carClassInput;

    @FindBy(xpath = "//input[@id = 'serialNumber']")
    WebElement carRegistrationInput;

    @FindBy(xpath = "//input[@id = 'price']")
    WebElement priceInput;

    @FindBy(xpath = "//textarea[@id = 'about']")
    WebElement aboutTextarea;

    @FindBy(xpath = "//label[@for = 'photos']")
    WebElement labelPhoto;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement submitButton;

    @FindBy(xpath = "//h1[text() = 'Car adding failed']")
    WebElement messageAfterUnsuccessfulCarAdding;

    @FindBy(xpath = "//button[text() = 'Ok']")
    WebElement buttonOk;

    public LetTheCarWorkPage handlerClickFuel() {
        clickOnElement(addressInput);
        return this;
    }

    public LetTheCarWorkPage handlerClickPhotos() {
        clickOnElement(addressInput);
        return this;
    }

    public LetTheCarWorkPage handlerClickButtonSubmit() {
        clickOnElement(addressInput);
        return this;
    }

    public LetTheCarWorkPage handleClickButtonOk() {
        clickOnElement(buttonOk);
        return this;
    }

    public LetTheCarWorkPage handleClickAbout() {
        clickOnElement(aboutTextarea);
        aboutTextarea.sendKeys("Black car");
        return this;
    }

    public LetTheCarWorkPage enterData(String address, String manufacture, String model, String year, String seats, String carClass, String registrationNumber, String price) {
        fillInputField(addressInput, address);
        fillInputField(manufactureInput, manufacture);
        fillInputField(modelInput, model);
        fillInputField(yearInput, year);
        fillInputField(seatsInput, seats);
        fillInputField(carClassInput, carClass);
        fillInputField(carRegistrationInput, registrationNumber);
        fillInputField(priceInput, price);
        return this;
    }

    public LetTheCarWorkPage enterData(DataTable table) {
        List<Map<String, String>> dataTableList = table.asMaps();
        return enterData(dataTableList.get(0).get("address"), dataTableList.get(0).get("manufacture"), dataTableList.get(0).get("model"), dataTableList.get(0).get("year"), dataTableList.get(0).get("seats"), dataTableList.get(0).get("carClass"), dataTableList.get(0).get("registrationNumber"), dataTableList.get(0).get("price"));
    }

    public LetTheCarWorkPage isUnSuccessCarToRent() {
        assert getElement(messageAfterUnsuccessfulCarAdding).getText().equals("Car adding failed");
        return this;
    }
}
