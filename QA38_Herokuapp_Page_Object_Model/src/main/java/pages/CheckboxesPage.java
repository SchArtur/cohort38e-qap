package pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxesPage extends BasePage {
    @FindBy(xpath = "//input[@type='checkbox'][1]")
    WebElement checkbox1;
    @FindBy(xpath = "//input[@type='checkbox'][2]")
    WebElement checkbox2;

    public CheckboxesPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @BeforeEach
    public void precondition(){
        new HomePage(driver,wait).clickCheckboxesLink();
    }
    public void handleClickCheckbox1() {
        clickOnElement(checkbox1);
    }
    public void handleClickCheckbox2() {
        clickOnElement(checkbox2);
    }

    public CheckboxesPage checkboxesPositive1() {
        precondition();
        handleClickCheckbox1();
        Assertions.assertTrue(checkbox1.isSelected(), "First checkbox has not been selected");
        return this;
    }
    public CheckboxesPage checkboxesNegative2() {
        precondition();
        Assertions.assertTrue(checkbox2.isSelected(), "Second checkbox has not been selected");
        handleClickCheckbox2();
        Assertions.assertFalse(checkbox2.isSelected(), "Second checkbox has been selected");
        return this;
    }
}
