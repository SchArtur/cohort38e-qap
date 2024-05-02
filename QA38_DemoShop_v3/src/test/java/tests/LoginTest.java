package tests;

import org.junit.jupiter.api.Test;
import page.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    void test1() {
        new LoginPage(driver, wait).login();
    }
}
