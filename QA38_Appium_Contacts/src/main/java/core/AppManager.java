package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class AppManager {
    public static AppiumDriver driver;

    public static void startApp() throws IOException {
        AppiumServerStarter.startServer();

        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.android.contacts")
                .setAppActivity("com.android.contacts.activities.PeopleActivity")
                .setAvd("Pixel")
                .setPlatformVersion("8");

//       Эквивалетные настройки
//       // Создаем объект DesiredCapabilities для настройки параметров сеанса Appium
//       DesiredCapabilities capabilities = new DesiredCapabilities();
//       // Указываем платформу - Android
//       capabilities.setCapability("platformName", "Android");
//       // Указываем движок автоматизации - UiAutomator2
//       capabilities.setCapability("automationName", "UiAutomator2");
//       // Указываем пакет приложения
//       capabilities.setCapability("appPackage", "com.google.android.deskclock");
//       // Указываем Activity приложения
//       capabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");
//       // Указываем имя эмулятора
//       capabilities.setCapability("avd", "android_jenkins_26");
//       //Указываем версию андроид
//       capabilities.setCapability("platformVersion", "8");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void stop() throws IOException {
        driver.quit();
        String adbPath = "/Users/alexandra/Library/Android/sdk/platform-tools/adb";
        Runtime.getRuntime().exec(adbPath + " -s emulator-5554 emu kill");
        AppiumServerStarter.stopServer();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}
