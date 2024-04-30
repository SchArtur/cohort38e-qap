package com.ait.qa.tests;

import org.junit.jupiter.api.*;
import page.ContactPage;
import page.LoginPage;

@Tag("@ContactTests")
@Tag("@ALL")
public class AddContactTests extends BaseTest {

    @BeforeEach
    void precondition() {
        new LoginPage(driver, wait).login();
    }

    @Test
    @Tag("@Positive")
    @Tag("@1")
    @DisplayName("Успешное создание контакта")
    void test1() {
        ContactPage contactPage = new ContactPage(driver, wait);
        contactPage.clickOnAddLink();
        contactPage.fillAddContactForm(testContact);
        contactPage.clickOnSaveButton();
        contactPage.contactIsPresent(testContact);
        contactPage.removeContactByName(testContact.getName());
    }

    @Test
    @Tag("@Negative")
    @DisplayName("Создание контакта с некорректным номером телефона")
    void test2() {
        ContactPage contactPage = new ContactPage(driver, wait);
        contactPage.clickOnAddLink();
        contactPage.fillAddContactForm(testContact.setPhone("JJ"));
        contactPage.clickOnSaveButton();
        Assertions.assertTrue(contactPage.getAlertText().contains("Phone not valid"), "Сообщение об ошибке не соответствует ожидаемому");
    }
}
