package page;

import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver, WebDriverWait wait) {
        BasePage.driver = driver;
        BasePage.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void fillInputField(WebElement e, String value) {
        LOGGER.info(() -> String.format("Заполняем поле ввода с локатором %s значением %s", e.toString(), value));
        WebElement element = waitForClickableElement(e);
        element.click();
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, element.getAttribute("value"));
    }

    protected static WebElement getElement(By locator) {
        return waitForVisibilityElement(driver.findElement(locator));
    }
    public void clickOnElement(WebElement element) {
        LOGGER.info(() -> String.format("Делаем click по элементу с локатором %s", element.toString()));
        waitForClickableElement(element).click();
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

    public boolean isElementPresent(List<WebElement> elements) {
        return !elements.isEmpty();
    }

    protected void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
