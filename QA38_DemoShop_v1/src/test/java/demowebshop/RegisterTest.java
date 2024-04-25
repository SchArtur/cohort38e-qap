package demowebshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest{
    @Test
    @Tag("@RegisterTest")
    @DisplayName("Проверка успешной регистрации")
    void test1() {
        clickOnLoginLink();
        clickOnRegisterButton();
        clickOnCheckBox();
        fillRegisterForm(new UserRegister("Bella", "Goltsman", "goltsman545@gamil.com", "nx5#w5pq5KgGGA", "nx5#w5pq5KgGGA"));
        clickOnRegisterButton();
        clickOnContinueButton();
        checkElementIsDisplayed(By.xpath("//a[contains(text(), 'Log out')]"));
    }
}
