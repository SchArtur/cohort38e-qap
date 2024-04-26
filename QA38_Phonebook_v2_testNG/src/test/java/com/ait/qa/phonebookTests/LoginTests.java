package com.ait.qa.phonebookTests;

import com.ait.qa.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.properties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {
    @BeforeMethod
    void precondition() {
        if (appManager.getUserHelper().isSignOutPresent()) {
            appManager.getUserHelper().clickOnSignOutButton();
        }
        appManager.getTestUser().setPassword(properties.getProperty("test_user_pass"));
    }

    @Test(description = "Проверка ввода неверного пароля", groups = {"Negative"})
    void test1() {
        appManager.getUserHelper().clickOnLoginLink();
        appManager.getUserHelper().fillLoginForm(appManager.getTestUser().setPassword("234t234"));
        appManager.getUserHelper().clickOnLoginButton();
        assertEquals("Wrong email or password", appManager.getUserHelper().getAlertText(), "Текст ошибки не соответствует ожидаемому");
    }

    @Test(description = "Проверка успешной авторизации", groups = {"Positive"})
    void test2() {
        appManager.getUserHelper().clickOnLoginLink();
        appManager.getUserHelper().fillLoginForm(appManager.getTestUser());
        appManager.getUserHelper().clickOnLoginButton();
        assertTrue(appManager.getUserHelper().isSignOutPresent());
    }

    @Test(description = "Проверка не успешной регистрации", groups = {"Negative"})
    void test3() {
        appManager.getUserHelper().clickOnLoginLink();
        appManager.getUserHelper().fillLoginForm(appManager.getTestUser().setPassword("123"));
        appManager.getUserHelper().clickOnRegistrationButton();
        assertTrue(appManager.getUserHelper().getAlertText().contains("Password must contain"), "Сообщение об ошибке не соответствует ожидаемому");
    }
}
