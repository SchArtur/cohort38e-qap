package page;

import model.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContactPage extends BasePage {

    @FindBy(css = "[href='/add']")
    WebElement addLink;
    @FindBy(css = "[href='/contacts']")
    WebElement contactsLink;
    @FindBy(xpath = "//*[text()='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//button[text()='Remove']")
    WebElement removeButton;
    @FindBy(css = "[placeholder='Name']")
    WebElement nameForm;
    @FindBy(css = "[placeholder='Last Name']")
    WebElement lastNameForm;
    @FindBy(css = "[placeholder='Phone']")
    WebElement phoneForm;
    @FindBy(css = "[placeholder='email']")
    WebElement emailForm;
    @FindBy(css = "[placeholder='Address']")
    WebElement addressForm;
    @FindBy(css = "[placeholder='description']")
    WebElement descriptionForm;
    @FindBy(className = "contact-item_card__2SOIM")
    List<WebElement> contactsList;
    @FindBy(xpath = "//h2")
    List<WebElement> contactsNameList;

    public ContactPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Нажатие на ссылку ADD
    public void clickOnAddLink() {
        clickOnElement(addLink);
    }

    //Нажатие на ссылку CONTACT
    public void clickOnContactLink() {
        clickOnElement(contactsLink);
    }

    //Нажатие на кнопку Save
    public void clickOnSaveButton() {
        clickOnElement(saveButton);
    }

    //Нажатие на кнопку Remove
    public void clickOnRemoveButton() {
        clickOnElement(removeButton);
    }


    //Заполняем поля контакт формы
    public void fillAddContactForm(Contact contact) {
        fillInputField(nameForm, contact.getName());
        fillInputField(lastNameForm, contact.getLastName());
        fillInputField(phoneForm, contact.getPhone());
        fillInputField(emailForm, contact.getEmail());
        fillInputField(addressForm, contact.getAddress());
        fillInputField(descriptionForm, contact.getDescription());
    }

    //Нажатие на контакт из списка по имени
    public WebElement getContactElementByName(String nameContact) {
        for (WebElement webElement : contactsNameList) {
            if (webElement.getText().equals(nameContact)) {
                return webElement;
            }
        }
        return null;
    }

    //Нажатие на контакт из списка по имени
    public void clickOnContactByName(String nameContact) {
        getContactElementByName(nameContact).click();
    }

    //Удаление контакта из списка по имени
    public void removeContactByName(String nameContact) {
        clickOnContactByName(nameContact);
        clickOnRemoveButton();
        waitInSeconds(2);
    }

    //Метод добавления контакта
    public void addContact(Contact contact) {
        clickOnAddLink();
        fillAddContactForm(contact);
        clickOnSaveButton();
    }

    //Получаем количество контактов
    public int sizeOfContacts() {
        if (!contactsList.isEmpty()) {
            //метод findElements возвращает List<WebElement>. Метод size возвращает число элементов в List
            return contactsList.size();
        } else return 0;
    }

    public void contactIsPresent(Contact contact) {
        checkElementIsDisplayed(getContactElementByName(contact.getName()));
    }
}