import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlertsTest extends BaseTest {

    @BeforeEach
    public void precondition(){
        new HomePage(driver,wait).clickOnJsAlert();
    }
    @Test
    void test(){
        new AlertsPage(driver,wait).clickButton1()
                .clickButton2Ok()
                .clickButton2Cancel()
                .writeAndOk()
                .writeAndCancel()
                .okOnly()
                .cancelOnly();
    }
}
