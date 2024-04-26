package page_helpers;

import model.User;
import model.UserRegister;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    void clickOnLoginButton() {
        clickOnElement(By.xpath("//input[@value='Log in']"));
    }

    void clickOnLoginLink() {
        clickOnElement(By.cssSelector("[href='/login']"));
    }

    void clickOnRegisterButton() {
        clickOnElement(By.xpath("//input[@value='Register']"));
    }

    void clickOnCheckBox() {
        clickOnElement(By.xpath("//input[@value='F']"));
    }

    void clickOnContinueButton() {
        clickOnElement(By.xpath("//input[@value='Continue']"));
    }

    void fillLoginForm(User user) {
        fillInputField(By.name("Email"), user.getEmail());
        fillInputField(By.name("Password"), user.getPassword());
    }

    void fillRegisterForm(UserRegister userRegister) {
        fillInputField(By.name("FirstName"), userRegister.getFirstName());
        fillInputField(By.name("LastName"),userRegister.getLastName());
        fillInputField(By.name("Email"),userRegister.getEmail());
        fillInputField(By.name("Password"),userRegister.getPassword());
        fillInputField(By.name("ConfirmPassword"),userRegister.getConfirmPassword());
    }
}
