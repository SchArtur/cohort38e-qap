package myWorksQA;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class RegistrationAndAddToCard extends MyBaseTestDemoWebShop2 {

    @Test
    @Tag("Test_01")
    @DisplayName("Регистрация на сайте Demo Web Shop")
    void registrationTest() {
        findElement(By.cssSelector(LOG_IN));
        clickOnElement(By.cssSelector(LOG_IN));
        findElement(By.xpath(REGISTRATION_BUTTON1));
        clickOnElement(By.xpath(REGISTRATION_BUTTON1));
        clickOnElement(By.cssSelector(MALE));
        fillInputFieldByName(
                "agfdsg",
                "dafdgd",
                "asdsa@sds.com",
                "Fdjfhdgd!.",
                "Fdjfhdgd!.");
        findElement(By.cssSelector(REGISTRATION_BUTTON2));
        clickOnElement(By.cssSelector(REGISTRATION_BUTTON2));
    }
}


