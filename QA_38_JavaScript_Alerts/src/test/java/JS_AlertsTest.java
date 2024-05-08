import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.HomePage;
import page.JS_AlertsPage;

public class JS_AlertsTest extends BaseTest {
    @BeforeEach
    public void precondition() {
        new HomePage(driver, wait)
                .clickJSAlerts();

    }

 @Test
    public void test1() {
        new JS_AlertsPage(driver, wait)
                .clickJSConfirmButton("OK");

    }
    @Test
    public void test2() {
        new JS_AlertsPage(driver, wait)
                .clickJSAlertButton("OK");

    }
    @Test
    public void test3() {
        new JS_AlertsPage(driver, wait)
                .clickJSPromptButton("OK");

    }




}
