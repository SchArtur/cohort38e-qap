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

public class MyBaseTestDemoWebShop2 {
    public static final String URL_DEMO_WEB_SHOP = "https://demowebshop.tricentis.com/";
    public static final String LOG_IN = ".ico-login";
    public static final String REGISTRATION_BUTTON1 = "//input[@class = 'button-1 register-button']";
    public static final String MALE = "[id = 'gender-male']";
    public static final String FEMALE = "[id = 'gender-female']";
    public static final String NAME = "[name = 'FirstName']";
    public static final String LASTNAME = "[name = 'LastName']";
    public static final String EMAIL = "[name = 'Email']";
    public static final String PASSWORD = "[name = 'Password']";
    public static final String CONF_PASSWORD = "[name = 'ConfirmPassword']";
    public static final String REGISTRATION_BUTTON2 = "[name = 'register-button']";
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

    public void findElement(By locator) {
        driver.findElement(locator);
    }

    void clickOnElement(By locator) {
        waitForClickableElement(driver.findElement(locator)).click();
    }

    public WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void fillInputFieldByName(String name, String lastname, String email, String pass, String confPass) {
        WebElement element1 = driver.findElement(By.cssSelector(NAME));
        element1.clear();
        element1.sendKeys(name);

        WebElement element2 = driver.findElement(By.cssSelector(LASTNAME));
        element2.clear();
        element2.sendKeys(lastname);

        WebElement element3 = driver.findElement(By.cssSelector(EMAIL));
        element3.clear();
        element3.sendKeys(email);

        WebElement element4 = driver.findElement(By.cssSelector(PASSWORD));
        element4.clear();
        element4.sendKeys(pass);

        WebElement element5 = driver.findElement(By.cssSelector(CONF_PASSWORD));
        element5.clear();
        element5.sendKeys(confPass);
    }

    public
    @AfterEach
    void afterVoid() {
        driver.quit();
    }
}
