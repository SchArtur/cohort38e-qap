package demowebshop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test
    @Tag("@LoginTest")
    @DisplayName("Проверка успешной авторизации")
    void test1() {

        clickOnLoginLink();
      //  fillInputField();
        fillLoginForm(new User("tested!123@gmail.com", "12345678"));
        clickOnLoginButton();
        checkElementIsDisplayed(By.xpath("//a[contains(text(), 'Log out')]"));
    }

}
