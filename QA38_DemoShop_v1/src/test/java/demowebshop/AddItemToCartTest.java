package demowebshop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddItemToCartTest extends BaseTest {
    @Test
    void test1() {
        int initialQuantity = getCartQuantity();
        List<WebElement> listElement = driver.findElements(By.cssSelector("[class='item-box']"));
        WebElement addToCard = listElement. get(1).findElement(By.cssSelector("[value='Add to cart']"));
        addToCard.click();
//        clickOnElement(By.xpath(ADD_TO_CART_BUTTON));
        waitInSeconds(5);
        verifyCartQuantityIncreased(initialQuantity);
    }
}
