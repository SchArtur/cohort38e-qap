package demowebshop;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class AddItemToCart extends BaseTest {

    @BeforeEach
    void start() {driver.get(BaseTest.url_demowebshop);

    }
    @Test
    void test1() {
        WebElement element = waitForVisibilityElement(driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[1]/a/img")));
        clickOnElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[2]/div[3]/div[2]/input"));
        WebElement element1 = waitForVisibilityElement(driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[2]")));
    }
}
