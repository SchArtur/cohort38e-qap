package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
public class JS_AlertsPage extends BasePage {
    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement clickJSAlertButton;
    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement clickJSConfirmButton;
    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement clickJSPromptButton;
    @FindBy(css = "[id = 'result']")
    WebElement result;


    public JS_AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public JS_AlertsPage clickJSConfirmButton(String choiceActive) {
        clickOnElement(clickJSConfirmButton);
        Alert alert = getAlert();
        if (choiceActive != null && choiceActive.equalsIgnoreCase("ok")) {
            alert.accept();
        } else alert.dismiss();
        return this;
    }
    public JS_AlertsPage clickJSAlertButton (String choiceActive) {
        clickOnElement(clickJSAlertButton);
        Alert alert = getAlert();
        if (choiceActive != null && choiceActive.equalsIgnoreCase("ok")) {
            alert.accept();
        } else alert.dismiss();
        return this;
    }
    public JS_AlertsPage clickJSPromptButton (String choiceActive) {
        clickOnElement(clickJSPromptButton);
        Alert alert = getAlert();
        if (choiceActive != null && choiceActive.equalsIgnoreCase("ok")) {
            alert.accept();
        } else alert.dismiss();
        return this;
    }
}