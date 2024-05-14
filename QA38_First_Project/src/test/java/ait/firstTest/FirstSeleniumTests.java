package ait.firstTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ait.BaseTest;

public class FirstSeleniumTests extends BaseTest {

    private static final String URL_CART = "http://95.140.153.145/litecart";
    private static final String URL_ADMIN = "http://95.140.153.145/litecart/admin";

    @Test //Самая главная аннотация, которая указывает что данный метод является тестом
    @Tag("@SMOKE") //  нужна для отдельного или группового запуска по тэгу
    @Tag("@ALL") //  нужна для отдельного или группового запуска по тэгу
    @DisplayName("Проверка заголовка страницы магазина")
// В данной аннотации мы задаем имя для отображения при запуске
    void testOpenLiteCart() {
//        driver.get(URL_CART); // без истории
        driver.navigate().to(URL_CART);//переход к странице по УРЛ с историей
        driver.navigate().back(); //  назад
        driver.navigate().forward();// вперед
        driver.navigate().refresh();  // обновить
        Assertions.assertEquals("Online Store | My Store", driver.getTitle(), "Открылась страница с другим title");
    }

    @Test
    @Disabled // исключает тест из запуска
    @Tag("@SMOKE")
    @DisplayName("Проверка заголовка страницы администратора магазина")
    void testOpenAdminLiteCart() {
        driver.navigate().to(URL_ADMIN);
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        Assertions.assertEquals("My Store", driver.getTitle(), "Заголовок страницы не соответствует ожидаемому");
        Assertions.assertEquals(true, driver.getTitle(), "Заголовок страницы не соответствует ожидаемому");
    }

    @Test
    @Tag("@SMOKE")
    @DisplayName("Проверка атрибутов Web элемента на сайте ilcarro")
    void testCssSelectors() {
        driver.navigate().to("https://ilcarro.web.app/search");
        WebElement elementById = driver.findElement(By.id("city"));
//Создайте, пожалуйста, новый тестовый класс и найдите 3 элемента на https://ilcarro.web.app/search по id, получите у этого элемента любой атрибут и сделайте проверку.
        Assertions.assertEquals("city", elementById.getAttribute("formcontrolname"), "Атрибут елемента по id страницы не соответствует ожидаемому");
    }

}