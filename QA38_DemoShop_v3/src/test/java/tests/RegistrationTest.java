package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;

public class RegistrationTest extends BaseTest{
    @Test
    void test2() {
        new RegistrationPage(driver, wait).registration();
    }
}
