package qa.demowebshop.addToCart;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import qa.demowebshop.BaseTest;

import static qa.demowebshop.utill.Constants.ADD_TO_CART_BUTTON;

public class AddItemToCart extends BaseTest {
    @Test
    void test1() {
        int initialQuantity = getCartQuantity();
        clickOnElement(By.xpath(ADD_TO_CART_BUTTON));
        waitInSeconds(3);
        verifyCartQuantityIncreased(initialQuantity);
    }
}
