import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FirstCalcTest {

    @Test
    void test1() throws MalformedURLException {
        AppiumServerStarter.startServer();
        //Настройки напрямую от UiAutomator2. Нужно указать только apk
        UiAutomator2Options capabilities = new UiAutomator2Options()
                .setApp(new File("src/test/resources/mobiCalculatorApp.apk").getAbsolutePath())
                .setPlatformVersion("14")
                .setAvd("Pixel");
        // Создаем объект AndroidDriver с указанными capabilities
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
        // Устанавливаем неявное ожидание в 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Находим элемент (кнопку) с идентификатором "my.android.calc:id/b021"
        WebElement element = driver.findElement(By.id("my.android.calc:id/b021"));
        // Нажимаем найденную кнопку
        element.click();

        // Завершаем сеанс Appium и закрываем драйвер
        driver.quit();
        AppiumServerStarter.stopServer();
    }

    @Test
    void test2() throws MalformedURLException {
        // Создаем объект DesiredCapabilities для настройки параметров сеанса Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Указываем платформу - Android
        capabilities.setCapability("platformName", MobilePlatform.ANDROID);
        // Указываем движок автоматизации - UiAutomator2
        capabilities.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        // Указываем пакет приложения
        capabilities.setCapability("appPackage", "my.android.calc");
        // Указываем активность приложения
        capabilities.setCapability("appActivity", "my.android.calc.MainActivity");

        //Эквивалентная запись для настроек через UiAutomator2Options
//        UiAutomator2Options capabilities = new UiAutomator2Options()
//                .setAppPackage("my.android.calc")
//                .setAppActivity("my.android.calc.MainActivity");

        // Создаем объект AndroidDriver с указанными capabilities
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
        // Устанавливаем неявное ожидание в 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Находим элемент (кнопку) с идентификатором "my.android.calc:id/b021"
        WebElement element = driver.findElement(By.id("my.android.calc:id/b021"));
        // Нажимаем найденную кнопку
        element.click();

        // Завершаем сеанс Appium и закрываем драйвер
        driver.quit();
    }

    @Test
    void test3() throws MalformedURLException {
        AppiumServerStarter.startServer();
        // Создаем объект DesiredCapabilities для настройки параметров сеанса Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Указываем платформу - Android
        capabilities.setCapability("platformName", "Android");
        // Указываем движок автоматизации - UiAutomator2
        capabilities.setCapability("automationName", "UiAutomator2");
        // Указываем пакет приложения
        capabilities.setCapability("appPackage", "com.google.android.deskclock");
        // Указываем Activity приложения
        capabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");


        // Создаем объект AndroidDriver с указанными capabilities
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
        // Устанавливаем неявное ожидание в 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Находим элемент с идентификатором доступности "Add city"
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Add city"));
        // Нажимаем найденный элемент
        element.click();
        // Находим элемент EditText
        WebElement textElement = driver.findElement(By.className("android.widget.EditText"));

        // Проверяем, что текст элемента соответствует ожидаемому
        Assertions.assertEquals(textElement.getText(), "Search for a city", "Текст не найден");

        // Завершаем сеанс Appium и закрываем драйвер
        driver.quit();
        AppiumServerStarter.stopServer();
    }

    @Test
    void checkSumOfTwoNumbersTest() throws MalformedURLException {
        AppiumServerStarter.startServer();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "my.android.calc");
        capabilities.setCapability("appActivity", "my.android.calc.MainActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement numberFive = driver.findElement(AppiumBy.id("my.android.calc:id/b021"));
        WebElement plus = driver.findElement(AppiumBy.id("my.android.calc:id/b032"));
        WebElement numberThree = driver.findElement(AppiumBy.id("my.android.calc:id/b043"));
        WebElement even = driver.findElement(AppiumBy.id("my.android.calc:id/b044"));

        numberFive.click();
        plus.click();
        numberThree.click();
        even.click();

        WebElement result = driver.findElement(By.id("my.android.calc:id/result"));
        int actualResult = Integer.parseInt(result.getText());
        int expectedResult = 8;

        Assertions.assertEquals(expectedResult, actualResult, "Sum of numbers should be " + expectedResult);

        driver.quit();
        AppiumServerStarter.stopServer();
    }
}
