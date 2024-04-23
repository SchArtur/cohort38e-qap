import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateAccountTest extends BaseTest {
    @Test
    void verifyRegistrationForm() {
        driver.navigate().to(LOGIN);
        fillInputFields("email", "Mickey5555@gmail.com");
        fillInputFields("password", "Mause555#");
        waitForClickableElement(driver.findElement(By.name("registration"))).click();
        WebElement signOutElement = waitForVisibilityElement(driver.findElement(By.xpath("//button[text()='Sign Out']")));
        Assertions.assertTrue(signOutElement.isDisplayed(), "Отсутствует копка выход");
        signOutElement.click();
    }

    void fillInputFields(String name, String value) {
        WebElement element = waitForVisibilityElement(driver.findElement(By.name(name)));
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, element.getAttribute("value"));
    }
}
