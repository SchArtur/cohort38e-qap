package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import page.LoginPage;

import static page.BasePage.driver;
import static page.BasePage.wait;

public class LoginSteps {

    /**
     * @Given()
     * @And()
     * @И
     * @Тогда
     * @Когда
     */

    @Когда("Пользователь открывает браузер")
    public void openBrowser() {
       new LoginPage(driver, wait).openBasePageBrowser();
    }

    @Тогда("Нажимает кнопку Login")
    public void loginClick() {
        new LoginPage(driver, wait).clickOnLoginLink();
    }
}
