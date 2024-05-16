package pages;

import core.AppManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    AppiumDriver driver;

    public BasePage() {
        this.driver = AppManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
