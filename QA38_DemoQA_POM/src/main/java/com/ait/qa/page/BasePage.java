package com.ait.qa.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait;
        PageFactory.initElements(driver, this);
    }

    protected void fillInputField(WebElement element, String value) {
        WebElement elementType = waitForVisibilityElement(element);//Получаем элемент по By.name который будем заполнять
        elementType.clear();// очищаем поле ввода, от возможных предустановленных значений
        elementType.sendKeys(value);//заполняем поле ввода переданным значением в параметрах
        Assertions.assertEquals(value, elementType.getAttribute("value"));// Проверяем что значение нашего поля ввода, точно заполнилось нашим значением
    }

    //Метод возвращает Веб Элемент для работы с ним по локатору
    protected WebElement getElement(WebElement elementr) {
        return waitForVisibilityElement(elementr);
    }

    //Метод делает клик по Веб Элемент с указанным локатором
    protected void clickOnElement(WebElement element) {
        waitForClickableElement(element).click();
    }

    //Метод ожидает что элемент станет видимым пользователю
    private WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Метод проверяет что элемент готов к клику.
    private WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));}

}
