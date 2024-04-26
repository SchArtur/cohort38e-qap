package page_helpers;

import core.AppManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.logging.Logger;

public class BaseHelper {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(BaseHelper.class);
    public static final String DEMO_WEB_SHOP = "https://demowebshop.tricentis.com/";

    @BeforeEach
    public void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(DEMO_WEB_SHOP);
    }

    @AfterEach
    void afterVoid() {
        driver.quit();
    }

    protected void fillInputField(By locator, String value) {
        WebElement element = waitForVisibilityElement(driver.findElement(locator));
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, element.getAttribute("value"));
    }

    protected static WebElement getElement(By locator) {
        return waitForVisibilityElement(driver.findElement(locator));
    }
    protected void clickOnElement(By locator) {
        waitForClickableElement(driver.findElement(locator)).click();
    }

    protected Alert getAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    private static WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    void checkElementIsDisplayed(By locator) {
        Assertions.assertTrue(getElement(locator).isDisplayed(), String.format("Ожидаемы елемент по %s локатору не найден", locator));
    }

    protected void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String takeScreenshot() {
        File tmp = ((TakesScreenshot) AppManager.driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(String.format("screenshots/screen%s.png", System.currentTimeMillis()));
        try {
            Files.copy(tmp.toPath(), screenshot.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }
}
