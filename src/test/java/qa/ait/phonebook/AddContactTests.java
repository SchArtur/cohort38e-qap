package qa.ait.phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import qa.ait.BaseTest;

import static qa.ait.utill.Constants.URL_PHONEBOOK;

public class AddContactTests extends BaseTest {


    @BeforeEach
    void login(){
        driver.navigate().to(URL_PHONEBOOK);
        clickOnElement(By.cssSelector("[href='/login']"));
        fillInputField(By.name("email"), "manuel@gm.com");
        fillInputField(By.name("password"), "Manuel1234$");
        clickOnElement(By.name("login"));
    }

    @Test
    @Tag("ContactTests")
    @DisplayName("Успешное создание контакта")
    void test1(){
        clickOnElement(By.cssSelector("[href='/add']"));
        fillInputField(By.cssSelector("[placeholder='Name']"), "Имя");
        fillInputField(By.cssSelector("[placeholder='Last Name'"), "Last Name");
        fillInputField(By.cssSelector("[placeholder='Phone'"), "12345678910");
        fillInputField(By.cssSelector("[placeholder='email'"), "email@email.com");
        fillInputField(By.cssSelector("[placeholder='Address'"), "Address");
        fillInputField(By.cssSelector("[placeholder='description'"), "description");
        clickOnElement(By.xpath("//*[text()='Save']"));
    }
}
