package tests;

import org.junit.jupiter.api.Test;
import pages.DropdownListPage;

public class DropdownListTest extends BaseTest {
    @Test
    void testDropdownOption1Positive() {
        new DropdownListPage(driver, wait).clickDropdownOption1Positive();
    }
    @Test
    void testDropdownOption2Positive() {
        new DropdownListPage(driver, wait).clickDropdownOption2Positive();
    }
}
