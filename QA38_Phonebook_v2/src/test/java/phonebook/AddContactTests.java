package phonebook;

import model.Contact;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

@Tag("@ContactTests")
public class AddContactTests extends BaseTest {

    private final Contact TEST_CONTACT = new Contact("Test", "Testoviy", "111111111111", "test@test.com", "Addresss", "Descr");

    @BeforeEach
    void precondition() {
        if (appManager.getUserHelper().isSignOutPresent()) {
            appManager.getUserHelper().clickOnSignOutButton();
        }
        appManager.getUserHelper().login(appManager.getTestUser());
    }

    @Test
    @DisplayName("Успешное создание контакта")
    void test1() {
        appManager.getContactHelper().clickOnAddLink();
        appManager.getContactHelper().fillAddContactForm(TEST_CONTACT);
        appManager.getContactHelper().clickOnSaveButton();
        appManager.getContactHelper().checkElementIsDisplayed(By.xpath(String.format("//h2[text()='%s']", TEST_CONTACT.getName())));
        appManager.getContactHelper().removeContactByName(TEST_CONTACT.getName());
    }

    @Test
    @DisplayName("Создание контакта с некорректным номером телефона")
    void test2() {
        appManager.getContactHelper().clickOnAddLink();
        appManager.getContactHelper().fillAddContactForm(TEST_CONTACT.setPhone("JJ"));
        appManager.getContactHelper().clickOnSaveButton();
        Assertions.assertTrue(appManager.getContactHelper().getAlertText().contains("Phone not valid"), "Сообщение об ошибке не соответствует ожидаемому");
    }
}
