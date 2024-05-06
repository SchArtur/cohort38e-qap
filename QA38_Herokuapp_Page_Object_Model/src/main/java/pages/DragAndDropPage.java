package pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//div[@id = 'column-a']")
    WebElement colum_A_Elem;
    @FindBy(xpath = "//div[@id = 'column-b']")
    WebElement colum_B_Elem;

    @BeforeEach
    public void precondition(){
        new HomePage(driver,wait).dragAndDropLink();
    }

    public void dragAndDropElements(WebElement sourceElement, WebElement targetElement) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).perform();
        Assertions.assertTrue(targetElement.isDisplayed(), "Target element is not visible after drag and drop.");
    }

    public DragAndDropPage checkIsDragAndDropColum_A() {
        precondition();
        dragAndDropElements(colum_A_Elem, colum_B_Elem);
        return this;
    }
    public DragAndDropPage checkIsDragAndDropColum_B() {
        precondition();
        dragAndDropElements(colum_B_Elem, colum_A_Elem);
        return this;
    }
}
