package pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenImagesPage extends BasePage {

    public BrokenImagesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//img[@src='asdf.jpg']")
    WebElement asdfImage;
    @FindBy(xpath = "//img[@src='hjkl.jpg']")
    WebElement hjklImage;
    @FindBy(xpath = "//img[@src='img/avatar-blank.jpg']")
    WebElement avatarImage;

    @BeforeEach
    public void precondition(){
        new HomePage(driver,wait).brokenImagesLink();
    }

    private Boolean isImageBroken(WebElement imageElement, boolean isExpectedToBeBroken) {
        Boolean isImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth!= \"undefined\" && arguments[0].naturalWidth > 0;",
                imageElement);
        if(isExpectedToBeBroken) {
            Assertions.assertFalse(isImagePresent, "Image is displayed");
        } else {
            Assertions.assertTrue(isImagePresent, "Image is not displayed");
        }
        return isImagePresent;
    }

    Boolean isBrokenImageAsdfPresent() {
        return isImageBroken(asdfImage, true);
    }
    Boolean isBrokenHjklImagePresent() {
        return isImageBroken(hjklImage, true);
    }
    Boolean isBrokenAvatarImagePresent() {
        return isImageBroken(avatarImage, false);
    }

    public BrokenImagesPage checkIsBrokenAsdfImage() {
        precondition();
        isBrokenImageAsdfPresent();
        return this;
    }
    public BrokenImagesPage checkIsBrokenHjklImage() {
        precondition();
        isBrokenHjklImagePresent();
        return this;
    }
    public BrokenImagesPage checkIsBrokenAvatarImage() {
        precondition();
        isBrokenAvatarImagePresent();
        return this;
    }
}
