import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends BasePage {


    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//*[text() = 'Click for JS Alert']")
    WebElement clickJSAlert;
    @FindBy(xpath = "//*[text() = 'Click for JS Confirm']")
    WebElement clickJSConfirm;
    @FindBy(xpath = "//*[text() = 'Click for JS Prompt']")
    WebElement clickOnJSPrompt;
    @FindBy(css = "[id = 'result']")
    WebElement result;

    public AlertsPage clickButton1() {
        clickOnElement(clickJSAlert);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        Assertions.assertEquals("You successfully clicked an alert", result.getText(), "Ошибка при нажатии на Ок!");
        return this;
    }

    public AlertsPage clickButton2Ok() {
        clickOnElement(clickJSConfirm);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        Assertions.assertTrue(result.getText().contains("Ok"), "Ошибка при подтверждении второго Алерта!");
        return this;
    }

    public AlertsPage clickButton2Cancel() {
        clickOnElement(clickJSConfirm);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        Assertions.assertTrue( result.getText().contains("Cancel"), "Ошибка при отмены второго Алерта!");
        return this;
    }

    public AlertsPage writeAndOk() {
        clickOnElement(clickOnJSPrompt);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Hello!");
        alert.accept();
        Assertions.assertTrue( result.getText().contains("Hello!"), "Ошибка при вводе с потверждением!");
        return this;
    }

    public AlertsPage writeAndCancel() {
        clickOnElement(clickOnJSPrompt);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("World");
        alert.dismiss();
        Assertions.assertTrue(result.getText().contains("null"), "Ошибка при вводе с отменой!");
        return this;
    }

    public AlertsPage okOnly() {
        clickOnElement(clickOnJSPrompt);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        Assertions.assertTrue( result.getText().contains(" "), "Ошибка при нажатии на Ок!");
        return this;
    }

    public AlertsPage cancelOnly() {
        clickOnElement(clickOnJSPrompt);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        Assertions.assertTrue(result.getText().contains("null"), "Ошибка при нажатии на Cancel!");
        return this;
    }
}
