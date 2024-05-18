import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ContactsPage;

public class ContactsPageTest extends BaseTest {
    @Test
    @DisplayName("Проверка добавления контакта")
    void test1() {
        new ContactsPage()
                .tapPlusContact()
                .typeInputFields()
                .tapSaveButton()
                .checkAddPhoneInContacts();
    }
}
