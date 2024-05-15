import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumServerStarter {
    private static AppiumDriverLocalService service;

    public static void startServer() {
        // Создаем объект AppiumServiceBuilder
        AppiumServiceBuilder builder = new AppiumServiceBuilder();

        // Устанавливаем путь к Appium
        builder.withAppiumJS(new File("/usr/local/bin/appium/"));

        // Устанавливаем порт для сервера Appium
        builder.withIPAddress("127.0.0.1").usingPort(4723);

        // Создаем экземпляр AppiumDriverLocalService
        service = AppiumDriverLocalService.buildService(builder);

        // Запускаем сервер Appium
        service.start();

        // Выводим сообщение о запуске сервера
        if (service.isRunning()) {
            System.out.println("Appium Server started");
        } else {
            System.out.println("Appium Server failed to start");
        }
    }

    public static void stopServer() {
        // Останавливаем сервер Appium
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium Server stopped");
        }
    }
}
