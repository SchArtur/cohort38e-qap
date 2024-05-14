package ait;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach // эта аннотация - указание, что метод выполниться перед каждым тестом
    //@BeforeAll // эта аннотация - указание, что метод выполниться перед всеми тестами
    public void startDriver() {
        driver = new ChromeDriver();
        //driver = new SafariDriver();
        driver.manage().window().maximize(); // разворачивает окно на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // неявное ожидание 5 секунд на загрузку элементов. Это вид ожидания, который позволяет приостановить работу WebDriver на определённый период времени, пока WebDriver не найдёт нужный элемент на веб-странице
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));// явное ожидания, по условиям. Это вид динамического ожидания в Selenium, которое позволяет остановить выполнение скрипта по определённому условию на заданный промежуток времени
    }

    @AfterEach
        // эта аннатация - указание, что метод выполниться после каждого теста
        //@AfterAll даже если ваш тест упал секция AFTER выполнится (кроме системных ошибок)
    void afterVoid() {
        driver.quit();
    }

    //Метод заполняет поля ввода по locator значением value
    protected void fillInputField(By locator, String value) {
        WebElement element = waitForVisibilityElement(driver.findElement(locator));//Получаем элемент по By.name который будем заполнять
        element.clear();// очищаем поле ввода, от возможных предустановленных значений
        element.sendKeys(value);//заполняем поле ввода переданным значением в параметрах
        Assertions.assertEquals(value, element.getAttribute("value"));// Проверяем что значение нашего поля ввода, точно заполнилось нашим значением
    }

    //Метод возвращает Веб Элемент для работы с ним по локатору
    protected WebElement getElement(By locator) {
        return waitForVisibilityElement(driver.findElement(locator));
    }

    //Метод делает клик по Веб Элемент с указанным локатором
    protected void clickOnElement(By locator) {
        waitForClickableElement(driver.findElement(locator)).click();
    }

    protected Alert getAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    //Метод ожидает что элемент станет видимым пользователю
    private WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Метод проверяет что элемент готов к клику.
    private WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}