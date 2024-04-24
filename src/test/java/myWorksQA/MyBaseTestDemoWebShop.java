package myWorksQA;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyBaseTestDemoWebShop {
    public static final String CART_QUANTITY = "//span[contains(@class, 'cart-qty') and text()='(0)']";

    public static final String URL_DEMO_WEB_SHOP = "https://demowebshop.tricentis.com/";
    public static final String ADD_TO_CART_BUTTON = "t";
    public static final String SHOPPING_CART = "//a[href='/cart']";
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(URL_DEMO_WEB_SHOP);
    }

    public void getElement(By locator) {
        driver.findElement(locator);
    }
    public WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    private WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    void clickOnElement(By locator) {
        waitForClickableElement(driver.findElement(locator)).click();
    }
    @AfterEach
    void afterVoid() {
        driver.quit();
    }
}
