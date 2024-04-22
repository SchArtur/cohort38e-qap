import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import qa.ait.BaseTest;

public class FindElementByXpath extends BaseTest {
    WebDriver driver;
    public void startDriver(){
        driver = new ChromeDriver();
    }
    @Test
    void findXpath(){
        driver.navigate().to("https://demowebshop.tricentis.com/");

    }
}
