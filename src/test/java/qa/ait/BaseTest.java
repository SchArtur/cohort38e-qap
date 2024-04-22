package qa.ait;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public static final String URL_LITECART = "http://95.140.153.145/litecart";
    public static final String URL_LITECART_ADMIN = "http://95.140.153.145/litecart/admin";
    public static final String URL_PHONEBOOK = "https://telranedu.web.app/";
    public static final String URL_ILCARRO = "https://ilcarro.web.app/search";
    protected static final String URL_WEB_SHOP = "https://demowebshop.tricentis.com/";

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach // эта аннотация - указание, что метод выполниться перед каждым тестом
//    @BeforeAll // эта аннотация - указание, что метод выполниться перед всеми тестами
    public void startDriver() {
        driver = new ChromeDriver();
//        driver = new SafariDriver();
        driver.manage().window().maximize(); // разворачивает окно на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // неявное ожидание 5 секунд на загрузку элементов
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));// явное ожидания, по условиям
    }

    @AfterEach // эта аннатация - указание, что метод выполниться после каждого теста
//    @AfterAll даже если ваш тест упал секция AFTER выполнится (кроме системных ошибок)
    void afterVoid() {
        driver.quit();
    }

//    Метод ожидант что элемент станет видимым пользователю
    public WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

//    Метож проверяет что элемент готов к клику.
    public WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
