package qa.ait.fifthHomework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qa.ait.BaseTest;

public class AddContactTest extends BaseTest {
    @Test
    void addContacts() {
        login();
        driver.navigate().to(BaseTest.ADD);
        fillInputs("name", "Mickey");
        fillInputs("lastName", "Mouse");
        fillInputs("phone", "+79986667688");
        fillInputs("email", "DisneyLand@gmail.com");
        fillInputs("address", "Bd de Parc, 77700 Coupvray, France");
        fillInputs("description", "la la la");
        WebElement save = waitForVisibilityElement(driver.findElement(By.xpath("//button[b='Save']")));
        Assertions.assertTrue(save.isDisplayed(), "Отсутствует копка выход");
        save.click();
    }

    void login() {
        driver.navigate().to(BaseTest.LOGIN);
        fillInputs("email", "manuel@gm.com");
        fillInputs("password", "Manuel1234$");
        driver.findElement(By.name("login")).click();
    }

    void fillInputs(String name, String value) {
        WebElement element = waitForVisibilityElement(driver.findElement(By.name(name)));
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, element.getAttribute("value"));
    }
}
