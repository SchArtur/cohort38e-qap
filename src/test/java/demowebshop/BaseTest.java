package demowebshop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class BaseTest {

    public static final String url_demowebshop = "https://demowebshop.tricentis.com/";
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach

    public void startDriver() {
        driver = new ChromeDriver();
        //driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(url_demowebshop);
    }

    @AfterEach

    void afterVoid() {
        driver.quit();
    }

    WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    protected void clickOnElement(By locator) {
        waitForClickableElement(driver.findElement(locator)).click();
    }

}
