package demowebshop;

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
import java.util.List;

public class BaseTest {

    public static final String url_demowebshop = "https://demowebshop.tricentis.com/";
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
        driver.get(url_demowebshop);
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

    //Метод возвращает всплывающее в браузере окно
    protected Alert getAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    //Метод ожидает что элемент станет видимым пользователю
    private WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Метод проверяет что элемент готов к клику.
    WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //Вынесли авторизацию отдельным методом
    public void login() {
        login(new User("tested!123@gmail.com","12345678"));
    }

    //Метод авторизации на сайте Phonebook c переданным параметром User
    public void login(User user) {
        clickOnLoginLink();
        fillLoginForm(user);
        clickOnLoginButton();
    }

    // Нажатие на ссылку LOGIN
    void clickOnLoginLink() {
        clickOnElement(By.cssSelector("[href='/login']"));
    }

    // Нажатие на ссылку HOME
    void clickOnHomeLink() {
        clickOnElement(By.cssSelector("[href='/home']"));
    }

    //Нажатие на ссылку ADD
    void clickOnAddLink() {
        clickOnElement(By.cssSelector("[href='/add']"));
    }

    //Нажатие на ссылку CONTACT
    void clickOnContactLink() {
        clickOnElement(By.cssSelector("[href='/contacts']"));
    }

    //Нажатие на кнопку Login
    void clickOnLoginButton() {
        clickOnElement(By.cssSelector("[value='Log in']"));
    }

    //Нажатие на кнопку registration
    void clickOnRegistrationButton() {
        clickOnElement(By.name("registration"));
    }

    //Нажатие на кнопу Sign Out
    void clickOnSignOutButton() {
        clickOnElement(By.xpath("//button[text()='Sign Out']"));
    }

    //Нажатие на кнопу Save
    void clickOnSaveButton() {
        clickOnElement(By.xpath("//*[text()='Save']"));
    }

    //Нажатие на кнопу Remove
    void clickOnRemoveButton() {
        clickOnElement(By.xpath("//button[text()='Remove']"));
    }

    //заполняем поля логин формы
    void fillLoginForm(User user) {
        //вводим емайл
        fillInputField(By.name("Email"), user.getEmail());
        //вводим пароль
        fillInputField(By.name("Password"), user.getPassword());
    }

   // Заполняем поля контакт формы
    void fillAddContactForm(Contact contact) {
        fillInputField(By.cssSelector("[placeholder='Name']"), contact.getFirstName());
        fillInputField(By.cssSelector("[placeholder='Last Name'"), contact.getLastName());

        fillInputField(By.cssSelector("[placeholder='email'"), contact.getEmail());


    }

    //Нажатие на контакт из списка по имени
    void clickOnContactByName(String nameContact) {
        clickOnElement(By.xpath(String.format("", nameContact)));
    }

    //Удаление контакта из списка по имени
    void removeContactByName(String nameContact) {
        clickOnContactByName(nameContact);
        clickOnRemoveButton();
        waitInSeconds(2);
    }

  //  Метод добавления контакта
    void addContact(Contact contact) {
        clickOnAddLink();
        fillAddContactForm(contact);
        clickOnSaveButton();
    }

    //Получаем количество контактов
    protected int sizeOfContacts() {
        if (getElement(By.cssSelector(".contact-item_card__2SOIM")).isDisplayed()) {
            //метод findElements возвращает List<WebElement>. Метод size возвращает число элементов в List
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        } else return 0;
    }

    //Проверяет наличие элемента по локатору
    void checkElementIsDisplayed(By locator) {
        Assertions.assertTrue(getElement(locator).isDisplayed(), String.format("Ожидаемы елемент по %s локатору не найден", locator));
    }
    protected boolean checkElementIsInCart() {
        WebElement cartQtyElement = getElement(By.cssSelector(".page-body"));
        List<WebElement> cartFormElements = cartQtyElement.findElements(By.xpath("//form[@action='/cart']"));
        return !cartFormElements.isEmpty();
    }
    //Ожидает указанное количество секунд
    protected void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}