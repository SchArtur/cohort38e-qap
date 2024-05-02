package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {
    public static final String DEMO_WEB_SHOP = "https://demowebshop.tricentis.com/";
    public WebDriver driver;
    public WebDriverWait wait;
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
}
