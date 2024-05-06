package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @FindBy(css = "[href = '/javascript_alerts']")
    WebElement javaScriptAlerts;
    @FindBy(css = "[href = '/checkboxes']")
    WebElement checkboxesPageLink;
    @FindBy(css = "[href = '/dropdown']")
    WebElement dropdownListPageLink;
    @FindBy(css="[href = '/broken_images']")
    WebElement brokenImagesLink;
    @FindBy(css="[href = '/drag_and_drop']")
    WebElement dragAndDropLink;

    public JavaScriptAlertsPage clickJsAlert(){
        clickOnElement(javaScriptAlerts);
        return new JavaScriptAlertsPage(driver,wait);
    }

    public CheckboxesPage clickCheckboxesLink(){
        clickOnElement(checkboxesPageLink);
        return new CheckboxesPage(driver,wait);
    }

    public DropdownListPage clickDropdownListLink(){
        clickOnElement(dropdownListPageLink);
        return new DropdownListPage(driver,wait);
    }

    public BrokenImagesPage brokenImagesLink(){
        clickOnElement(brokenImagesLink);
        return new BrokenImagesPage(driver,wait);
    }

    public DragAndDropPage dragAndDropLink(){
        clickOnElement(dragAndDropLink);
        return new DragAndDropPage(driver,wait);
    }
}
