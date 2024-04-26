package core;

import model.UserRegister;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_helpers.CartHelper;
import page_helpers.UserHelper;

import java.time.Duration;
import java.util.Properties;

public class AppManager {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties properties = TestProperties.getInstance().getProperties();
    public static final String URL_PHONEBOOK = properties.getProperty("api.url");

    private String browser = properties.getProperty("browser");

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CartHelper getCartHelper() {
        return cartHelper;
    }

    public User getTestUser() {
        return testUser;
    }

    public CartHelper getTestCart() {
        return testCart;
    }

    private UserHelper userHelper;
    private CartHelper carHelper;
    private User testUser;
    private UserRegister testRegister;
    private final Logger LOG = LoggerFactory.getLogger(AppManager.class);

    public void init() {
        LOG.info(String.format("Инициализируем драйвер %s браузера", browser));
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(URL_PHONEBOOK);

        userHelper = new UserHelper(driver, wait);
        testUser = new User(properties.getProperty("test_user_name"), properties.getProperty("test_user_pass"));
    }

    public void stop() {
        driver.close();
        driver.quit();
    }
}
