import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver,WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }
    public WebElement waitForClickableElement(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForVisibilityElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement getElement(WebElement element){
        return waitForClickableElement(element);
    }
    public void clickOnElement(WebElement element){
        waitForClickableElement(element).click();
    }
    public Alert getAlert(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }
}
