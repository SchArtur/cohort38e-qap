package ait.phonebook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ait.BaseTest;

import static ait.utill.Constants.URL_PHONEBOOK;

public class HomePageTests extends BaseTest {

    @Test
    @Tag("HomeTests")
    @DisplayName("Переход в Home")
    void test1() {
        //Переходим на страницу
        driver.navigate().to(URL_PHONEBOOK);
        //нажимаем кнопку HOME
        clickOnElement(By.cssSelector("[href='/home']"));
        //проверяем корректность перехода в страницу HOME
        Assertions.assertTrue(getElement(By.xpath("//h1[text()='Home Component']")).isDisplayed());
    }
}
