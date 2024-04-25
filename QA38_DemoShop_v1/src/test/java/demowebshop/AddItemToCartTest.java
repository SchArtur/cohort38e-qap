package demowebshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddItemToCartTest extends BaseTest {
    @Test
    @Tag("@AddItemToCart")
    @DisplayName("Проверка успешного добавления в корзину")
    void test1() {
        List<WebElement> listElement = driver.findElements(By.cssSelector("[class='item-box']"));
        WebElement addToCard = listElement. get(1).findElement(By.cssSelector("[value='Add to cart']"));
        addToCard.click();
        waitInSeconds(3);
        clickOnShoppingCartLink();
        waitInSeconds(2);
        checkElementIsInCart();
    }
}

//    @Test
//    void test1() {
//        int initialQuantity = getCartQuantity();
//        List<WebElement> listElement = driver.findElements(By.cssSelector("[class='item-box']"));
//        WebElement addToCard = listElement. get(1).findElement(By.cssSelector("[value='Add to cart']"));
//        addToCard.click();
//        waitInSeconds(5);
//        verifyCartQuantityIncreased(initialQuantity);
//    }
