package com.ait.qa.tests;

import org.junit.jupiter.api.*;
import page.ContactPage;
import page.LoginPage;

@Tag("@ContactTests")
@Tag("@ALL")
@Tag("@Regression")
public class DeleteContactTests extends BaseTest {

    @BeforeEach
    void precondition() {
        new LoginPage(driver, wait).login();
        new ContactPage(driver, wait).addContact(testContact);
    }

    @Test
    @Tag("@Positive")
//    @Disabled
    @DisplayName("Успешное удаление контакта")
    void test1() {
        ContactPage contactPage = new ContactPage(driver, wait);
        contactPage.clickOnContactLink();
        int beforeRemove = contactPage.sizeOfContacts();
        contactPage.clickOnContactByName(testContact.getName());
        contactPage.clickOnRemoveButton();
        contactPage.waitInSeconds(3);
        int afterRemove = contactPage.sizeOfContacts();
        Assertions.assertEquals(beforeRemove - 1, afterRemove, "Количество контактов не изменилось");
    }
}
