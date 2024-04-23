package qa.ait.firstTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import qa.ait.BaseTest;

import static qa.ait.utill.Constants.URL_LITECART_ADMIN;

public class SecondSeleniumTest extends BaseTest {

    @Test
    void test1() {
        driver.navigate().to(URL_LITECART_ADMIN);
        Assertions.assertEquals("My Store", driver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

    @Test
    void test2() {
        driver.navigate().to(URL_LITECART_ADMIN);
        Assertions.assertEquals("My Store", driver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

    @Test
    void test3() {
        driver.navigate().to(URL_LITECART_ADMIN);
        Assertions.assertEquals("My Store", driver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

    @Test
    void test4() {
        driver.navigate().to(URL_LITECART_ADMIN);
        Assertions.assertEquals("My Store", driver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

    @Test
    void test5() {
        driver.navigate().to(URL_LITECART_ADMIN);
        Assertions.assertEquals("My Store", driver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

    @Test
    void test6() {
        driver.navigate().to(URL_LITECART_ADMIN);
        Assertions.assertEquals("My Store", driver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

    @Test
    void test7() {
        driver.navigate().to(URL_LITECART_ADMIN);
        Assertions.assertEquals("My Store", driver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

    @Test
    void test8() {
        driver.navigate().to(URL_LITECART_ADMIN);
        Assertions.assertEquals("My Store", driver.getTitle(), "Заголовок не соответствует ожидаемому");
    }

}
