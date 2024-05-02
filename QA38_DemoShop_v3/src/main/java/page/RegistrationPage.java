package page;

import model.UserRegister;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = ("//input[@value='Register']"))
    WebElement buttonRegister;
    @FindBy(xpath = ("//input[@value='Continue']"))
    WebElement buttonContinue;
    @FindBy(xpath = ("//input[@value='F']"))
    WebElement checkBox;
    @FindBy(name = ("FirstName"))
    WebElement firstName;
    @FindBy(name = ("LastName"))
    WebElement lastName;
    @FindBy(name = ("Email"))
    WebElement email;
    @FindBy(name = ("Password"))
    WebElement password;
    @FindBy(name = ("ConfirmPassword"))
    WebElement confirmPassword;
    @FindBy(css = "[href='/login']")
    WebElement loginLink;
    @FindBy(xpath = ("//a[text()='Log out']"))
    WebElement logOutLink;

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }
    void clickOnRegisterButton() {
        clickOnElement(buttonRegister);
    }
    void clickOnCheckBox() {
        clickOnElement(checkBox);
    }
    void fillRegisterForm(UserRegister userRegister) {
        fillInputField((firstName), userRegister.getFirstName());
        fillInputField((lastName),userRegister.getLastName());
        fillInputField((email),userRegister.getEmail());
        fillInputField((password),userRegister.getPassword());
        fillInputField((confirmPassword),userRegister.getConfirmPassword());
    }
    void clickOnContinueButton() {
        clickOnElement(buttonContinue);
    }
    void checkIsLogOutPresent() {
        checkElementIsDisplayed(logOutLink);
    }
    public void registration() {
        clickOnLoginLink();
        clickOnRegisterButton();
        clickOnCheckBox();
        fillRegisterForm(new UserRegister("Bella", "Goltsman", "goltsman545787777@gamil.com", "nx5#w5pq5KgGGAABBBB", "nx5#w5pq5KgGGAABBBB"));
        clickOnRegisterButton();
        clickOnContinueButton();
        checkIsLogOutPresent();
    }
}
