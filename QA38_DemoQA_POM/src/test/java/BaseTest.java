import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    public static final String URL_PHONEBOOK = "https://telranedu.web.app/";
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(URL_PHONEBOOK);
    }

    @AfterEach
        // эта аннатация - указание, что метод выполниться после каждого теста
        //@AfterAll даже если ваш тест упал секция AFTER выполнится (кроме системных ошибок)
    void afterVoid() {
        driver.quit();
    }

}
