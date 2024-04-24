package qa.demowebshop.addToCart;

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

public class BaseTest {
    public static final String DEMO_WEB_SHOP = "https://demowebshop.tricentis.com/";
    public static final String ADD_TO_CART_BUTTON = "/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[2]/div[3]/div[2]/input";
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

    void clickOnElement(By locator) {
        waitForClickableElement(driver.findElement(locator)).click();
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
}
