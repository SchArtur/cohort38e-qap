package qa.ait.parametrizedTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qa.ait.BaseTest;

import static qa.ait.utill.Constants.URL_LITECART_ADMIN;

public class FirstParamsTest extends BaseTest {

    @ParameterizedTest //указание что данный Тест параметризированный.
    @CsvSource({
            URL_LITECART_ADMIN + ", username, admin, password, admin38Qa, //*[@title='Logout']",
            "https://telranedu.web.app/login, email,  manuel@gm.com, password, Manuel1234$, //button[text()='Sign Out']"
    })
    void checkParamsLoginTest(String url, String nameField, String nameValue, String passFields, String passValue, String xPathLogOut) {
        driver.navigate().to(url);
        clickOnElement(By.cssSelector("[href='/login']"));
        fillInputField(By.name(nameField), nameValue);
        fillInputField(By.name(passFields), passValue);
        clickOnElement(By.name("login"));
        clickOnElement(By.xpath("//button[text()='Sign Out']"));
    }
}
