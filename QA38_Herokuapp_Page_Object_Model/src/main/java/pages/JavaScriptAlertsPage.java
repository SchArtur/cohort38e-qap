package pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptAlertsPage extends BasePage{
    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement clickForJsAlertLink;
    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement clickForJsConfirmLink;
    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement clickForJsPromptLink;
    @FindBy(css = "[id = 'result']")
    WebElement result;

    public JavaScriptAlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @BeforeEach
    public void precondition(){
        new HomePage(driver,wait).clickJsAlert();
    }

    public void clickOnJsAlert() {
        precondition();
        clickOnElement(clickForJsAlertLink);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
    public JavaScriptAlertsPage clickOnJsConfirm() {
        precondition();
        clickOnElement(clickForJsConfirmLink);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        Assertions.assertTrue(result.getText().contains("Ok"));
        return this;
    }
    public JavaScriptAlertsPage clickOnJsPrompt() {
        precondition();
        clickOnElement(clickForJsPromptLink);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Hello");
        alert.accept();
        Assertions.assertTrue(result.getText().contains("Hello"), "Mistake with entering");
        return this;
    }

    public void handleJsAlert() {
        clickOnJsAlert();
    }
    public void handleJsConfirm() {
        clickOnJsConfirm();
    }
    public void handleJsPrompt() {
        clickOnJsPrompt();
    }
}
