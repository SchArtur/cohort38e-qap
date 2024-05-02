package tests;

import org.junit.jupiter.api.Test;
import pages.JavaScriptAlertsPage;

public class JavaScriptAlertsTest extends BaseTest {
    @Test
    void test1() {
        new JavaScriptAlertsPage(driver, wait).handleJsAlert();
    }
    @Test
    void test2() {
        new JavaScriptAlertsPage(driver, wait).handleJsConfirm();
    }
    @Test
    void test3() {
        new JavaScriptAlertsPage(driver, wait).handleJsPrompt();
    }
}
