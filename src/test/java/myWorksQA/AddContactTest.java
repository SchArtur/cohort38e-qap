package myWorksQA;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddContactTest extends BaseTest {


    @Test
    public void RegistrationAndCreateContact() {
        driver.navigate().to("https://telranedu.web.app/about");
        WebElement login = driver.findElement(By.xpath("//*[@href = '/login']"));
        login.click();
        WebElement email1 = driver.findElement(By.name("email"));
        email1.clear();
        email1.sendKeys("user123@example.com");
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("ApX7*LmNq!");
        WebElement registration = driver.findElement(By.name("login"));
        registration.click();

        WebElement addContact = driver.findElement(By.xpath("//a[contains(text(),'ADD')]"));
        addContact.click();

        WebElement name = driver.findElement(By.cssSelector("input[placeholder = 'Name']"));
        name.clear();
        name.sendKeys("Дядя");

        WebElement lastName = driver.findElement(By.cssSelector("input[placeholder = 'Last Name']"));
        lastName.clear();
        lastName.sendKeys("Толя");

        WebElement phone = driver.findElement(By.cssSelector("input[placeholder = 'Phone']"));
        phone.clear();
        phone.sendKeys("+452039487236");

        WebElement email2 = driver.findElement(By.cssSelector("input[placeholder = 'email']"));
        email2.clear();
        email2.sendKeys("ljaljalja@ooo.gg");

        WebElement address = driver.findElement(By.cssSelector("input[placeholder = 'Address']"));
        address.clear();
        address.sendKeys("Гвадылупа/Улица Именя Дяди Толи/Дом 51");

        WebElement description = driver.findElement(By.cssSelector("input[placeholder = 'description']"));
        description.clear();
        description.sendKeys("ljaljalja");

        WebElement save = driver.findElement(By.cssSelector("button b"));
        save.click();

        WebElement signOut = driver.findElement(By.xpath("//button[contains(text(),'Sign Out')]"));
        signOut.click();
    }
}
