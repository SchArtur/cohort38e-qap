package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@value='Log in']")
    WebElement loginButton;
    @FindBy(name = "Email")
    WebElement emailForm;
    @FindBy(name = "Password")
    WebElement passwordForm;
    @FindBy(css = "[href='/login']")
    WebElement loginLink;
    @FindBy(xpath = ("//a[text()='Log out']"))
    WebElement logOutLink;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void login(User user) {
        clickOnLoginLink();
        fillUserLoginForm(user);
        clickOnLoginButton();
    }

    public void fillUserLoginForm(User user) {
        fillInputField(emailForm, user.getEmail());
        fillInputField(passwordForm, user.getPassword());
    }

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public void clickOnLogOutButton() {
        clickOnElement(logOutLink);
    }

    public boolean isLogOutPresent() {
        return logOutLink.isDisplayed();
    }
}
