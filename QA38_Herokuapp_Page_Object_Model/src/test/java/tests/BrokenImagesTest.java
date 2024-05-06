package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BrokenImagesPage;

public class BrokenImagesTest extends BaseTest {
    @Test
    @Tag("@Smoke")
    @DisplayName("Checking is broken asdf image")
    void testCheckIsBrokenAsdfImage() {
        new BrokenImagesPage(driver, wait).checkIsBrokenAsdfImage();
    }

    @Test
    @Tag("@Smoke")
    @Tag("@Regression")
    @DisplayName("Checking is broken hjkl image")
    void testCheckIsBrokenHjklImage() {
        new BrokenImagesPage(driver, wait).checkIsBrokenHjklImage();
    }

    @Test
    @Tag("@Smoke")
    @Tag("@Regression")
    @DisplayName("Checking is broken avatar image")
    void testCheckIsBrokenAvatarImage() {
        new BrokenImagesPage(driver, wait).checkIsBrokenAvatarImage();
    }
}
