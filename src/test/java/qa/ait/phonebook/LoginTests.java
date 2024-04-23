package qa.ait.phonebook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qa.ait.BaseTest;

import static qa.ait.utill.Constants.URL_PHONEBOOK;

public class LoginTests extends BaseTest {

    @Test
    @Tag("LoginTests")
    @DisplayName("Проверка успешной авторизации")
    void test1() {
        //   Переходим на страницу
        driver.navigate().to(URL_PHONEBOOK);
//        нажимаем кнопку логин
        clickOnElement(By.cssSelector("[href='/login']"));
//        вводим емайл
        fillInputField(By.name("email"), "manuel@gm.com");
//        вводим пароль
        fillInputField(By.name("password"), "Manuel1234$");
//        нажимаем кнопку логин
        clickOnElement(By.name("login"));
//        проверяем что есть  кнопка выход
        Assertions.assertTrue(getElement(By.xpath("//button[text()='Sign Out']")).isDisplayed());
    }

//    TODO
    @Test
    @Tag("LoginTests")
    @DisplayName("Проверка ввода неверного пароля")
    void test2() {
        //   Переходим на страницу
        driver.navigate().to(URL_PHONEBOOK);
//        нажимаем кнопку логин
        clickOnElement(By.cssSelector("[href='/login']"));
//        вводим емайл
        fillInputField(By.name("email"), "manuel@gm.com");
//        вводим пароль
        fillInputField(By.name("password"), "Manuel12");
//        нажимаем кнопку логин
        clickOnElement(By.name("login"));

    }

}
