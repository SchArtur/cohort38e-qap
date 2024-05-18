package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class ContactsPage extends BasePage {

    @AndroidFindBy(id = "floating_action_button")
    WebElement plusContact;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"First name\")")
    WebElement firstNameInput;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Last name\")")
    WebElement lastNameInput;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Phone\")")
    WebElement phoneInput;
    @AndroidFindBy(id = "editor_menu_save_button")
    WebElement saveButton;
    @AndroidFindBy(id = "header")
    WebElement contactHeader;

    public ContactsPage tapPlusContact() {
        tap(plusContact);
        return this;
    }

    public ContactsPage tapSaveButton() {
        tap(saveButton);
        return this;
    }

    public ContactsPage typeInputFields() {
        type(firstNameInput, "Milana");
        type(lastNameInput, "Goltsman");
        type(phoneInput, "+49 5679 94353335");
        return this;
    }

    public ContactsPage checkAddPhoneInContacts() {
        Assertions.assertEquals("+49 5679 94353335", contactHeader.getText());
        return this;
    }
}
