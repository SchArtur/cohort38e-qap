package qa.ait.demoshop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qa.ait.BaseTest;
import qa.ait.utill.Constants;

import java.util.List;

public class DemoShop extends BaseTest {

    @Test
    void test1() {
        driver.get(Constants.URL_WEB_SHOP);
        List<WebElement> listElement = driver.findElements(By.cssSelector("[class='item-box']"));
        WebElement addToCard = listElement.get(1).findElement(By.cssSelector("[value='Add to cart']"));
        WebElement addToCard2 = getElement(By.cssSelector("[data-productid='31']")).findElement(By.cssSelector("[value='Add to cart']"));
        WebElement addToCard3 = getElement(By.cssSelector("//*[@data-productid='31']/descendant::input[@value='Add to cart']"));
        List<WebElement> listElement2 = driver.findElements(By.xpath("//*[@class='product-item']/descendant::input[@value='Add to cart']"));
        listElement2.get(1).click();


        addToCard.click();
    }
}
