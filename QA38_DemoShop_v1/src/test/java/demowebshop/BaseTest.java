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
import java.util.List;

public class BaseTest {
    public static final String DEMO_WEB_SHOP = "https://demowebshop.tricentis.com/";
//    public static final String CART_QUANTITY = "//span[@class='cart-qty']";

    public static WebDriver driver;
    public static WebDriverWait wait;

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

//    protected int getCartQuantity() {
//        WebElement cartQtyElement = getElement(By.xpath(CART_QUANTITY));
//        String cartQtyText = cartQtyElement.getText().replaceAll("\\D", "");
//        return Integer.parseInt(cartQtyText);
//    }
//
//    protected void verifyCartQuantityIncreased(int initialQuantity) {
//        int currentQuantity = getCartQuantity();
//        Assertions.assertEquals(initialQuantity + 1, currentQuantity,
//                "Expected cart quantity to increase by 1, but actual quantity is: " + currentQuantity);
//    }

    protected boolean checkElementIsInCart() {
        WebElement cartQtyElement = getElement(By.cssSelector(".page-body"));
        List<WebElement> cartFormElements = cartQtyElement.findElements(By.xpath("//form[@action='/cart']"));
        return !cartFormElements.isEmpty();
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

    void clickOnLoginButton() {
        clickOnElement(By.xpath("//input[@value='Log in']"));
    }

    void clickOnLoginLink() {
        clickOnElement(By.cssSelector("[href='/login']"));
    }

    void clickOnRegisterButton() {
        clickOnElement(By.xpath("//input[@value='Register']"));
    }

    void fillLoginForm(User user) {
        fillInputField(By.name("Email"), user.getEmail());
        fillInputField(By.name("Password"), user.getPassword());
    }

    void fillRegisterForm(UserRegister userRegister) {
        fillInputField(By.name("FirstName"), userRegister.getFirstName());
        fillInputField(By.name("LastName"),userRegister.getLastName());
        fillInputField(By.name("Email"),userRegister.getEmail());
        fillInputField(By.name("Password"),userRegister.getPassword());
        fillInputField(By.name("ConfirmPassword"),userRegister.getConfirmPassword());
    }

    void clickOnCheckBox() {
        clickOnElement(By.xpath("//input[@value='F']"));
    }

    void clickOnContinueButton() {
        clickOnElement(By.xpath("//input[@value='Continue']"));
    }

    void clickOnShoppingCartLink() {
        clickOnElement(By.xpath("//a[@href='/cart']"));
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
}