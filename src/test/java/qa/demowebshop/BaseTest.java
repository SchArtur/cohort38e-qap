package qa.demowebshop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static qa.demowebshop.utill.Constants.CART_QUANTITY;
import static qa.demowebshop.utill.Constants.DEMO_WEB_SHOP;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach // эта аннотация - указание, что метод выполниться перед каждым тестом
    public void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // разворачивает окно на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // неявное ожидание 5 секунд на загрузку элементов. Это вид ожидания, который позволяет приостановить работу WebDriver на определённый период времени, пока WebDriver не найдёт нужный элемент на веб-странице
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));// явное ожидания, по условиям. Это вид динамического ожидания в Selenium, которое позволяет остановить выполнение скрипта по определённому условию на заданный промежуток времени
        driver.get(DEMO_WEB_SHOP);
    }

    protected WebElement getElement(By locator) {
        return waitForVisibilityElement(driver.findElement(locator));
    }

    protected void clickOnElement(By locator) {
        waitForClickableElement(driver.findElement(locator)).click();
    }

    protected int getCartQuantity() {
        WebElement cartQtyElement = getElement(By.xpath(CART_QUANTITY));
        String cartQtyText = cartQtyElement.getText().replaceAll("\\D", "");;
        return Integer.parseInt(cartQtyText);
    }

    protected void verifyCartQuantityIncreased(int initialQuantity) {
        int currentQuantity = getCartQuantity();
        Assertions.assertEquals(initialQuantity + 1, currentQuantity,
                "Expected cart quantity to increase by 1, but actual quantity is: " + currentQuantity);
    }

    @AfterEach
        // эта аннатация - указание, что метод выполниться после каждого теста
    void afterVoid() {
        driver.quit();
    }

    private WebElement waitForVisibilityElement(WebElement element) {
       return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
