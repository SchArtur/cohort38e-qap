package tests;

import org.junit.jupiter.api.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {
    @Test
    void testCheckbox1Positive() {
        new CheckboxesPage(driver, wait).checkboxesPositive1();
    }
    @Test
    void testCheckbox2Positive() {
        new CheckboxesPage(driver, wait).checkboxesNegative2();
    }
}
