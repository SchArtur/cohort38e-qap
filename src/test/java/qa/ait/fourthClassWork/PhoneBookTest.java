package qa.ait.fourthClassWork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qa.ait.BaseTest;

public class PhoneBookTest extends BaseTest {
    @Test
    void verifyLoginForm() {
        driver.navigate().to(LOGIN);
        fillInputFieldByName("email", "manuel@gm.com");
        fillInputFieldByName("password", "Manuel1234$");
        waitForClickableElement(driver.findElement(By.name("login"))).click();
        WebElement signOutElement = waitForVisibilityElement(driver.findElement(By.xpath("//button[text()='Sign Out']")));
        Assertions.assertTrue(signOutElement.isDisplayed(), "Отсутствует копка выход");
        signOutElement.click();
    }

    public void fillInputFieldByName(String name, String value) {
        WebElement element = waitForVisibilityElement(driver.findElement(By.name(name)));
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, element.getAttribute("value"));
    }
}
