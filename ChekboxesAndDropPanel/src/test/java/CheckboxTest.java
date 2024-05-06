import org.example.BasePage;
import org.example.CheckboxPage;
import org.example.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxTest extends BaseTest {

    @BeforeEach
    public void precondition(){
        new HomePage(driver,wait).clickOnCheckbox();
    }

    @Test
    void checkboxTest(){
        new CheckboxPage(driver,wait).clickOnCheckboxes();
    }
}
