package com.ait.qa.phonebookTests;

import com.ait.qa.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DeleteContactTests extends BaseTest {

    @BeforeMethod
    void precondition() {
        if (appManager.getUserHelper().isSignOutPresent()) {
            appManager.getUserHelper().clickOnSignOutButton();
        }
        appManager.getUserHelper().login(appManager.getTestUser());
        appManager.getContactHelper().addContact(appManager.getTestContact());
    }

    @Test(description = "Успешное удаление контакта", groups = {"Positive"})
    void test1() {
        appManager.getContactHelper().clickOnContactLink();
        int beforeRemove = appManager.getContactHelper().sizeOfContacts();
        appManager.getContactHelper().clickOnContactByName(appManager.getTestContact().getName());
        appManager.getContactHelper().clickOnRemoveButton();
        appManager.getContactHelper().waitInSeconds(3);
        int afterRemove = appManager.getContactHelper().sizeOfContacts();
        assertEquals(beforeRemove - 2, afterRemove, "Количество контактов не изменилось");
    }
}
