package ait.parametrizedTests;

import ait.utill.Constants;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ait.BaseTest;

public class FirstParamsTest extends BaseTest {

    @ParameterizedTest //указание, что данный Тест параметризированный.
//    @ValueSource - аннотация, которая указывает, что данные для параметризации будут передаваться в формате строки.
    @ValueSource(strings = {Constants.URL_LITECART_ADMIN, "https://telranedu.web.app/login"})
    void checkParamsTest(String url) {
        driver.navigate().to(url);
        WebElement element = driver.findElement(By.cssSelector("[href='/login']"));
        element.click();
    }

    @ParameterizedTest
// @CsvSource - аннотация, которая указывает, что данные для параметризации будут передаваться в формате CSV.
    @CsvSource({
            Constants.URL_LITECART_ADMIN + ", username, admin, password, admin38Qa, //*[@title='Logout']",
            "https://telranedu.web.app/login, email,  manuel@gm.com, password, Manuel1234$, //button[text()='Sign Out']"
    })
    void checkParamsLoginTest(String url, String nameField, String nameValue, String passFields, String passValue, String xPathLogOut) {
        driver.navigate().to(url);
        fillInputField(By.name(nameField), nameValue);
        fillInputField(By.name(passFields), passValue);
        clickOnElement(By.name("login"));
        clickOnElement(By.xpath(xPathLogOut));
    }
}
