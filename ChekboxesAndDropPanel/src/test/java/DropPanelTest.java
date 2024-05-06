import org.example.DropDownPage;
import org.example.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DropPanelTest extends BaseTest {
    @BeforeEach
    public void precondition(){
        new HomePage(driver,wait).clickOnDropDown();
    }
    @Test
    void dropDownTest1(){
        new DropDownPage(driver,wait).clickDropDownOption1();
    }
    @Test
    void dropDownTest2(){
        new DropDownPage(driver,wait).clickDropDownOption2();
    }
}
