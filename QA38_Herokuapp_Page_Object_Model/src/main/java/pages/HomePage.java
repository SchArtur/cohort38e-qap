package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @FindBy(css = "[href = '/javascript_alerts']")
    WebElement javaScriptAlerts;

    public JavaScriptAlertsPage clickJsAlert(){
        clickOnElement(javaScriptAlerts);
        return new JavaScriptAlertsPage(driver,wait);
    }
}
