package myWorksQA;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateAccountTest extends BaseTest {


    @Test
    public void findElementsForRegistrationTest() {
        driver.navigate().to("https://telranedu.web.app/about");
        WebElement login = driver.findElement(By.xpath("//*[@href = '/login']"));
        login.click();
        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("user3656@example.com");
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("FDApR9@vY3x!.");
        WebElement registration = driver.findElement(By.name("registration"));
        registration.click();
        WebElement signOut = driver.findElement(By.xpath("//button[contains(text(),'Sign Out')]"));
        signOut.click();
    }
}
