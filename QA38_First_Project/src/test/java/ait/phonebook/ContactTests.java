package ait.phonebook;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import ait.BaseTest;

import static ait.utill.Constants.URL_PHONEBOOK;

public class ContactTests extends BaseTest {

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
    @DisplayName("Успешное удаление контакта")
    void test1(){

    }

}
