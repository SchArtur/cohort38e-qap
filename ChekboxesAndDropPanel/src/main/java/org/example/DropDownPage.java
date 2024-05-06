package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownPage extends BasePage {

    public DropDownPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//select[@id='dropdown']")
    WebElement dropdownSelect;
    @FindBy(xpath = "//option[@value='1']")
    WebElement option1;
    @FindBy(xpath = "//option[@value='2']")
    WebElement option2;

    public DropDownPage clickDropDownOption1() {
        clickOnElement(dropdownSelect);
        clickOnElement(option1);
        Assertions.assertTrue(option1.isSelected(), "Not Selected!");
        return this;
    }

    public DropDownPage clickDropDownOption2() {
        clickOnElement(dropdownSelect);
        clickOnElement(option2);
        Assertions.assertTrue(option2.isSelected(), "Not Selected!");
        return this;
    }
}