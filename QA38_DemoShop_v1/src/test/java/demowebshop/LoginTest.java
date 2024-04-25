package demowebshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest{
    @Test
    @Tag("@LoginTests")
    @DisplayName("Проверка успешной авторизаци")
    void test1() {
        clickOnLoginLink();
        fillLoginForm(new User("Sena555@google.com", "eDjzm4zRMs*a!x"));
        clickOnLoginButton();
        checkElementIsDisplayed(By.xpath("//a[contains(text(), 'Log out')]"));
    }

    @Test
    @Tag("@LoginTests")
    @DisplayName("Проверка ввода неверной почты")
    void test2() {
        clickOnLoginLink();
        fillLoginForm(new User("Sena555@google.com", "eDjzm4zRs*a!x"));
        clickOnLoginButton();
        Assertions.assertEquals("Login was unsuccessful. Please correct the errors and try again. No customer account found", getAlert().getText(), "Текст ошибки не соответствует ожидаемому");
    }

}
