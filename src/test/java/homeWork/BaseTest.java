package homeWork;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected static final String URL_HW = "https://demowebshop.tricentis.com/";


    @BeforeEach // эта аннотация - указание, что метод выполниться перед каждым тестом
//    @BeforeAll // эта аннотация - указание, что метод выполниться перед всеми тестами
    public void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // разворачивает окно на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // неявное ожидание 10 секунд на загрузку элементов
    }

    @AfterEach // эта аннатация - указание, что метод выполниться после каждого теста
    void afterVoid() {
        driver.quit();
    }
}
