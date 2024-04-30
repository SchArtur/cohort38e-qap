package com.ait.qa.tests;

import model.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LoginPage;

import java.time.Duration;

public class BaseTest {
    public static final String URL_PHONEBOOK = "https://telranedu.web.app/login";
    public WebDriver driver;
    public WebDriverWait wait;
    Contact testContact = new Contact("Test", "Testoviy", "111111111111", "test@test.com", "Addresss", "Descr");

    @BeforeEach
    public void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(URL_PHONEBOOK);
    }

    @AfterEach
    void afterVoid() {
        driver.quit();
    }

}
