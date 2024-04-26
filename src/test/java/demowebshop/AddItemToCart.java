package demowebshop;

import org.junit.After;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddItemToCart extends BaseTest {

    @BeforeEach
    void start() {
        driver.get(BaseTest.url_demowebshop);

    }
    @Test
    void test1() {

        List<WebElement> listElement = driver.findElements(By.cssSelector("[class='product-item']"));
        WebElement addToCard = listElement.get(1).findElement(By.cssSelector("[value='Add to cart']"));
        addToCard.click();
        waitInSeconds(3);
        driver.findElement(By.cssSelector("[class='cart-label']")) ;
        waitInSeconds(3);
        checkElementIsInCart();


//        WebElement cartItem = driver.findElement(By.cssSelector("[action='/cart']"));
//        Assertions.assertTrue(cartItem.isDisplayed());

        }


//        @After
//        public void tearDown() {
//
//            driver.quit();
//        }
}
