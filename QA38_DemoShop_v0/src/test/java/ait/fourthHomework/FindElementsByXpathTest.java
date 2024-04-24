package ait.fourthHomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ait.BaseTest;


public class FindElementsByXpathTest extends BaseTest {
    @BeforeEach
    void start() {
        driver.get(URL_WEB_SHOP);
    }

    @Test
    public void verifyElementsVisibility() {
        WebElement titleHeading = driver.findElement(By.xpath("//h3"));
        checkElementDisplay(titleHeading);

        WebElement formByGetMethod = driver.findElement(By.xpath("//form[@method='get']"));
        checkElementDisplay(formByGetMethod);

        WebElement topCartLink = driver.findElement(By.xpath("//*[@id='topcartlink']"));
        checkElementDisplay(topCartLink);

        WebElement firstListItem = driver.findElement(By.xpath("//li[1]"));
        checkElementDisplay(firstListItem);

        WebElement divWithText = driver.findElement(By.xpath("//div[contains(text(),'All rights reserved.')]"));
        checkElementDisplay(divWithText);

        WebElement product72Element = driver.findElement(By.xpath("//*[@data-productid='72']"));
        checkElementDisplay(product72Element);

        WebElement laptopLink = driver.findElement(By.xpath("//a[@href='/141-inch-laptop']"));
        checkElementDisplay(laptopLink);

        WebElement shoppingCartHeading = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        checkElementDisplay(shoppingCartHeading);

        WebElement unorderedList = driver.findElement(By.xpath("//ul"));
        checkElementDisplay(unorderedList);

        WebElement headerMenuDiv = driver.findElement(By.xpath("//div[contains(@class, 'header-menu')]"));
        checkElementDisplay(headerMenuDiv);
    }

    private void checkElementDisplay(WebElement element) {
        Assertions.assertTrue(element.isDisplayed(), "'" + element + "' не отображается на странице");
    }
}
