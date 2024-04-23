package qa.ait;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccountTest {
    WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new ChromeDriver();

    }

    @Test
    public void findElementsForRegistrationTest() {
        driver.navigate().to("https://telranedu.web.app/about");
        WebElement login = driver.findElement(By.xpath("//*[@href = '/login']"));
        login.click();
        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("Admin_123@rara.du");
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("Admin_0987!.");
        WebElement registration = driver.findElement(By.name("registration"));
        registration.click();
        WebElement signOut = driver.findElement(By.xpath("//button[contains(text(),'Sign Out')]"));
        signOut.click();
    }
}
