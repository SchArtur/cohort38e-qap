package homeWork;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

    public class BaseTest {
        public WebDriver driver;
        protected static final String url_demowebshop = "https://demowebshop.tricentis.com/";


        @BeforeEach

        public void startDriver() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @AfterEach
        void afterVoid() {
            driver.quit();
        }
    }

