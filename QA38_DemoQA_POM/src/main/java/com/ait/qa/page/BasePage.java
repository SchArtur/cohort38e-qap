package com.ait.qa.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    protected void fillInputField(WebElement element, String value) {
        WebElement elementType = waitForVisibilityElement(element);
        elementType.clear();
        elementType.sendKeys(value);
        Assertions.assertEquals(value, elementType.getAttribute("value"));
    }

    //Метод возвращает Веб Элемент для работы с ним по локатору
    protected WebElement getElement(WebElement elementr) {
        return waitForVisibilityElement(elementr);
    }

    //Метод делает клик по Веб Элемент с указанным локатором
    protected void clickOnElement(WebElement element) {
        waitForClickableElement(element).click();
    }

    protected Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    //Метод ожидает что элемент станет видимым пользователю
    private WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Метод проверяет что элемент готов к клику.
    private WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //Метод выполняющий клик по элементу через javascript код
    protected void clickElement(WebElement element) {
        js.executeScript("arguments[0].click()", element);
    }

    //Метод делает прокрутку по странице по заданным координатам.
//    protected void scrollPage() {
//        js.executeScript("window.scrollBy(150,0)");
//    }
    public BasePage scrollPage() {
        js.executeScript("window.scrollBy(150,0)");
        return this;
    }

    //    Метод отправляет запрос и получает ответ по ссылке
    public boolean isLinkValid(String link) {
        try {
            URL url = new URL(link);
//            Создаем коннект к нашему адресу (URLу)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            Устанавливаем таймаут
            connection.setConnectTimeout(5000);
//           Делаем сам коннект
            connection.connect();
//            Получаем статус ответа и проверяем что он меньше 500(это код ответа)
            return connection.getResponseCode() < 500;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isImageValid(WebElement image) {
//        Получаем boolean значение имеет ли наша картинка реальный размер или нет
        boolean isImageDisplayed = (boolean) js.executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth > 0);",image);
        return isImageDisplayed;
    }
}
