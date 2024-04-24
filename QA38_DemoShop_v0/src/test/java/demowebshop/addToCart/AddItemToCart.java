package demowebshop.addToCart;

import demowebshop.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static demowebshop.utill.Constants.ADD_TO_CART_BUTTON;

public class AddItemToCart extends BaseTest {
    @Test
    void test1() {
        int initialQuantity = getCartQuantity();
        clickOnElement(By.xpath(ADD_TO_CART_BUTTON));
        waitInSeconds(3);
        verifyCartQuantityIncreased(initialQuantity);
    }
}
