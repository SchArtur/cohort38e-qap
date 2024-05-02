package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptAlertsPage extends BasePage{
    @FindBy(css = "[href='/javascript_alerts']")
    WebElement javascriptLink;
    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement clickForJsAlertLink;
    @FindBy(xpath = "//button[text='Click for JS Confirm']")
    WebElement clickForJsConfirmLink;
    @FindBy(xpath = "//button[text='Click for JS Prompt']")
    WebElement clickForJsPromptLink;
    public JavaScriptAlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnJavascriptLink() {
        clickOnElement(javascriptLink);
    }

    public void clickOnJsAlert() {
        clickOnElement(clickForJsAlertLink);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
    public void clickOnJsConfirm() {
        clickOnElement(clickForJsConfirmLink);
    }
    public void clickOnJsPrompt() {
        clickOnElement(clickForJsPromptLink);
    }

    public void handleJsAlert() {
        clickOnJavascriptLink();
        clickOnJsAlert();
    }
    public void handleJsConfirm() {
        clickOnJavascriptLink();
        clickOnJsConfirm();
    }
    public void handleJsPrompt() {
        clickOnJavascriptLink();
        clickOnJsPrompt();
    }
}
