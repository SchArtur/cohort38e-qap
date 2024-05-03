package pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownListPage extends BasePage {
    @FindBy(xpath = "//select[@id='dropdown']")
    WebElement dropdownSelect;
    @FindBy(xpath = "//option[@value='1']")
    WebElement option1;
    @FindBy(xpath = "//option[@value='2']")
    WebElement option2;

    public DropdownListPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @BeforeEach
    public void precondition(){
        new HomePage(driver,wait).clickDropdownListLink();
    }

    public void handleClickDropdown() {
        clickOnElement(dropdownSelect);
    }
    public void handleClickOption1() {
        clickOnElement(option1);
    }
    public void handleClickOption2() {
        clickOnElement(option2);
    }

    public DropdownListPage clickDropdownOption1Positive() {
        precondition();
        handleClickDropdown();
        handleClickOption1();
        Assertions.assertTrue(option1.isSelected(), "First option has not been selected");
        return this;
    }
    public DropdownListPage clickDropdownOption2Positive() {
        precondition();
        handleClickDropdown();
        handleClickOption2();
        Assertions.assertTrue(option2.isSelected(), "Second option has not been selected");
        return this;
    }
}
