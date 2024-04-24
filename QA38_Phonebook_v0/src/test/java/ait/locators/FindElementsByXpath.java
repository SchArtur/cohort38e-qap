package ait.locators;

import ait.utill.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ait.BaseTest;

public class FindElementsByXpath extends BaseTest {

    /*
     * Самое главное отличие CSS от xPath это возможность обратиться к родителю
     *
     *Символы в xPath
     * 1) * - выбрать любой элемант
     * 2) [] - Найти конкретный элемент, например //li[2]
     * 3) имя узла, это имя тэга, например div
     *
     *  /html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]
     * 4) / Идем от корневого узла /html/body/div
     * 5) // Ищет узлы которые мы укажем по тэгу  например //body
     * 6) . Ищет текущий узел //body/. (будет body)
     * 7) .. Ищет родителя текущего узла //body/.. (будет html)
     * 8) @ - указание на атрибут элемента //a[@class='ico-login'] == //a[text()='Log in']
     * */

    /* Методы xPath
     *  text() - возращает текстовое содержимое элемента  //span[text()="Shopping cart"]
     *  count() - возвращает количество элементов   - ---
     *  contains() - проверяет содержит ли строка подстроку //span[contains(text(),'Shoppin')]
     * */

    /*
    * //ul[@class='top-menu']/descendant::a[contains(text(),'Notebooks')] https://demowebshop.tricentis.com/
    *
    * В XPath есть несколько осей, которые можно использовать при создании выражений:
        1) child::note — Выбирает все узлы note, которые являются прямыми потомками текущего узла
        2) attribute::date — Выбирает атрибут date текущего узла
        3) child::* — Выбирает всех прямых потомков текущего узла
        4) attribute::* — Выбирает все атрибуты текущего узла
        5) child::text() — Выбирает все текстовые узлы текущего узла
        6) child::node() — Выбирает всех прямых потомков текущего узла
        7) descendant::div — Выбирает всех потомков div текущего узла
        8) ancestor::div — Выбирает всех предков div текущего узла
        9) ancestor-or-self::div — Выбирает всех предков div текущего узла, а также сам текущий узел, если это узел div
        10) child::* /child::div — Выбирает всех прямых потомков прямых потомков (“внуков") div текущего узла
        11) last() — Выделяет последний элемент в дереве.
    * */

    @Test
    void findElementByXpath() {
        driver.get(Constants.URL_WEB_SHOP);
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Shoppin')]"));
        Assertions.assertTrue(element.isDisplayed(), String.format("Элемент %s не отображается на странице", element));

        WebElement element1 = driver.findElement(By.xpath("//span[@class='cart-qty']"));
        Assertions.assertTrue(element1.isDisplayed(), String.format("Элемент %s не отображается на странице", element1));

        WebElement element2 = driver.findElement(By.xpath("//div[3]"));
        Assertions.assertFalse(element2.isDisplayed(), String.format("Элемент %s не отображается на странице", element2));

        WebElement element3 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[2]/div/div[1]/a/img"));
        Assertions.assertTrue(element3.isDisplayed(), String.format("Элемент %s не отображается на странице", element3));

        WebElement element4 = driver.findElement(By.xpath("span"));
        Assertions.assertTrue(element4.isDisplayed(), String.format("Элемент %s не отображается на странице", element4));

        WebElement element5 = driver.findElement(By.xpath("//script[@type='text/javascript']"));
        Assertions.assertTrue(element5.isDisplayed(), String.format("Элемент %s не отображается на странице", element5));

        WebElement element6 = driver.findElement(By.xpath("//a[text()='Log in']"));
        Assertions.assertTrue(element6.isDisplayed(), String.format("Элемент %s не отображается на странице", element6));

        WebElement element7 = driver.findElement(By.xpath("//a[text()='Log in']/.."));
        Assertions.assertTrue(element7.isDisplayed(), String.format("Элемент %s не отображается на странице", element7));

        WebElement element8 = driver.findElement(By.xpath("//*[@id='bar-notification']"));
        Assertions.assertTrue(element8.isDisplayed(), String.format("Элемент %s не отображается на странице", element8));

        WebElement element9 = driver.findElement(By.xpath("//*[@data-productid='2']/."));
        Assertions.assertTrue(element9.isDisplayed(), String.format("Элемент %s не отображается на странице", element9));

        WebElement element10 = driver.findElement(By.xpath("//strong[contains(text(),'Recentl')]"));
        Assertions.assertTrue(element10.isDisplayed(), String.format("Элемент %s не отображается на странице", element10));
    }
}
