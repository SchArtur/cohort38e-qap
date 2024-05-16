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
        UiAutomator2Options options = new UiAutomator2Options()
            .setAppPackage("com.android.contacts")
            .setAppActivity("com.android.contacts.activities.PeopleActivity")
            .setAvd("Pixel")
            .setPlatformVersion("8");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void stop() throws IOException {
        driver.quit();
        Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");
        AppiumServerStarter.stopServer();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}
