package demowebshop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AddItemToCart extends BaseTest {
    @Test
    void test1() {
        int initialQuantity = getCartQuantity();
        clickOnElement(By.xpath(ADD_TO_CART_BUTTON));
        waitInSeconds(5);
        verifyCartQuantityIncreased(initialQuantity);
    }
}
