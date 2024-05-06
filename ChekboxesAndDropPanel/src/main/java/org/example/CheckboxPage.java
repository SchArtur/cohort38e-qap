package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxPage extends BasePage {
    public CheckboxPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//input[@type='checkbox'][1]")
    WebElement checkbox1;

    @FindBy(xpath = "//input[@type='checkbox'][2]")
    WebElement checkbox2;

    public CheckboxPage clickOnCheckboxes() {
        clickOnElement(checkbox1);
        clickOnElement(checkbox2);
        return this;
    }
}
