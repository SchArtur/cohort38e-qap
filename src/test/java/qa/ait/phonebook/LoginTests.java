package qa.ait.phonebook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qa.ait.BaseTest;

public class LoginTests extends BaseTest {

    @Test
    void checkClickAboutTest() {
        driver.get(URL_PHONEBOOK);
        WebElement elementAbout = driver.findElement(By.cssSelector("[href='/about']"));
        waitForClickableElement(elementAbout).click();
        WebElement elementTitle = driver.findElement(By.tagName("h2"));
        Assertions.assertEquals("Test App", elementTitle.getText(), "h2 не Test App");
    }

    @Test
    void checkLoginTest() {
        driver.navigate().to(URL_LITECART_ADMIN);
        fillInputFieldByName("username", "admin");
        fillInputFieldByName("password", "admin38Qa");
        waitForClickableElement(driver.findElement(By.name("login"))).click();
        WebElement logOutElement = waitForVisibilityElement(driver.findElement(By.cssSelector("[title='Logout']")));
        Assertions.assertTrue(logOutElement.isDisplayed(), "Отсутствует копка выход");
        logOutElement.click();
    }
    @ParameterizedTest //указание что данный Тест параметризированный.
    @CsvSource({
            URL_LITECART_ADMIN + ", username, admin, password, admin38Qa, //*[@title='Logout']",
            "https://telranedu.web.app/login, email,  manuel@gm.com, password, Manuel1234$, //button[text()='Sign Out']"
    })
    void checkParamsLoginTest(String url, String nameField, String nameValue, String passFields, String passValue, String xPathLogOut) {
        driver.navigate().to(url);
        fillInputFieldByName(nameField, nameValue);
        fillInputFieldByName(passFields, passValue);
        waitForClickableElement(driver.findElement(By.name("login"))).click();
        WebElement logOutElement = waitForVisibilityElement(driver.findElement(By.xpath(xPathLogOut)));
        Assertions.assertTrue(logOutElement.isDisplayed(), "Отсутствует копка выход");
        logOutElement.click();
    }
}
