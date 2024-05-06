package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }
    @FindBy(css = "[href = '/checkboxes']")
    WebElement checkboxes;

    @FindBy(css = "[href = '/dropdown']")
    WebElement dropdown;

    public CheckboxPage clickOnCheckbox(){
        clickOnElement(checkboxes);
        return new CheckboxPage(driver,wait);
    }
    public DropDownPage clickOnDropDown(){
        clickOnElement(dropdown);
        return new DropDownPage(driver,wait);
    }
}
