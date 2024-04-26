package com.ait.qa.phonebookTests;

import com.ait.qa.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class AddContactTests extends BaseTest {

    @BeforeMethod
    void precondition() {
        if (appManager.getUserHelper().isSignOutPresent()) {
            appManager.getUserHelper().clickOnSignOutButton();
        }
        appManager.getUserHelper().login(appManager.getTestUser());
    }

    @Test(description = "Успешное создание контакта")
    void test1() {
        appManager.getContactHelper().clickOnAddLink();
        appManager.getContactHelper().fillAddContactForm(appManager.getTestContact());
        appManager.getContactHelper().clickOnSaveButton();
        appManager.getContactHelper().contactIsPresent(appManager.getTestContact());
        appManager.getContactHelper().removeContactByName(appManager.getTestContact().getName());
    }

    @Test(description = "Создание контакта с некорректным номером телефона", groups = {"Nagative"})
    void test2() {
        appManager.getContactHelper().clickOnAddLink();
        appManager.getContactHelper().fillAddContactForm(appManager.getTestContact().setPhone("JJ"));
        appManager.getContactHelper().clickOnSaveButton();
        assertTrue(appManager.getContactHelper().getAlertText().contains("Phone not valid"), "Сообщение об ошибке не соответствует ожидаемому");
    }
}
