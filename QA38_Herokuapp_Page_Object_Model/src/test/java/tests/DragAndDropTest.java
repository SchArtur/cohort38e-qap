package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {
    @Test
    @Tag("@Smoke")
    @DisplayName("Checking of successful drag and drop A to B")
    void testDragAndDropColum_A() {
        new DragAndDropPage(driver, wait).checkIsDragAndDropColum_A();
    }

    @Test
    @Tag("@Smoke")
    @Tag("@Regression")
    @DisplayName("Checking of successful drag and drop B to A")
    void testDragAndDropColum_B() {
        new DragAndDropPage(driver, wait).checkIsDragAndDropColum_B();
    }
}
