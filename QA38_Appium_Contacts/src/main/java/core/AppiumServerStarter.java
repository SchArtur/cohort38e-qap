package core;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class AppiumServerStarter {
    private static AppiumDriverLocalService service;
    private static Logger logger = LoggerFactory.getLogger(AppiumServerStarter.class);

    public static void startServer() throws IOException {

        AppiumServiceBuilder builder = new AppiumServiceBuilder();

        builder.withAppiumJS(new File("/usr/local/bin/appium"));
        builder.withIPAddress("127.0.0.1").usingPort(4723);
        service = AppiumDriverLocalService.buildService(builder);
        try {
            service.start();
        } catch (AppiumServerHasNotBeenStartedLocallyException e) {
            Runtime.getRuntime().exec("pkill -9 -f appium");
            service.start();
        }

        if (service.isRunning()) {
            logger.info("Appium server started");
        } else {
            logger.info("Appium server failed start");
        }
    }
    public static void stopServer() {
        service.stop();
        logger.info("Appium server stopped");
    }
}
