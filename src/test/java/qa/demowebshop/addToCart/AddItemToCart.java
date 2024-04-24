package qa.demowebshop.addToCart;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AddItemToCart extends BaseTest {
    @Test
     void test1() {
        getElement(By.xpath(ADD_TO_CART_BUTTON));
        clickOnElement(By.xpath(ADD_TO_CART_BUTTON));
    }
}
