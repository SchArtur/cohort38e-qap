import org.junit.jupiter.api.*;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import java.time.Duration;

public class BaseTest {
    protected static final String LOGIN = "https://telranedu.web.app/login";
    protected static final String ADD = "https://telranedu.web.app/add";
    protected static final String URL_WEB_SHOP = "https://demowebshop.tricentis.com/";
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
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
