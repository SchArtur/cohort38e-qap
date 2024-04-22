import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



    public class Find10ElementsCss {
        WebDriver driver;

        @BeforeEach
        public void startDriver() {
            driver = new ChromeDriver();
        }

        @Test
        @Tag("Test_03")
        @DisplayName("Нахождение 10 элементов By.cssSelector на сайте https://demowebshop.tricentis.com/")
        public void findElementByCssSelectors() {
            driver.navigate().to("https://demowebshop.tricentis.com/");

            WebElement element1 = driver.findElement(By.cssSelector("a.ico-register"));
            Assertions.assertTrue(element1.isDisplayed(), "Элемент по css тэгу и классу не отображается на странице");

            WebElement element2 = driver.findElement(By.cssSelector(".ico-login"));
            Assertions.assertTrue(element2.isDisplayed(), "Элемент по css классу не отображается на странице");

            WebElement element3 = driver.findElement(By.cssSelector(".cart-label"));
            Assertions.assertTrue(element3.isDisplayed(), "Элемент по css классу не отображается на странице");

            WebElement element4 = driver.findElement(By.cssSelector("div.title"));
            Assertions.assertTrue(element4.isDisplayed(), "Элемент по css тегу и классу не отображается на странице");

            WebElement element5 = driver.findElement(By.cssSelector("span.cart-label"));
            Assertions.assertTrue(element5.isDisplayed(), "Элемент по css тегу и классу не отображается на странице");

            WebElement element6 = driver.findElement(By.cssSelector("div.footer-menu-wrapper"));
            Assertions.assertTrue(element6.isDisplayed(), "Элемент по css тегу и классу не отображается на странице");

            WebElement element7 = driver.findElement(By.cssSelector("h2.topic-html-content-header"));
            Assertions.assertTrue(element7.isDisplayed(), "Элемент по css тегу и классу не отображается на странице");

        }
        @Test
        void findElementByXpath(){
            driver.navigate().to("https://demowebshop.tricentis.com/");

            WebElement element2 = driver.findElement(By.xpath("//img[@alt = 'Picture of $25 Virtual Gift Card']"));
            Assertions.assertTrue(element2.isDisplayed(),String.format("Элемента %s нет на странице" ,element2));

            WebElement element3 = driver.findElement(By.xpath("//img[@alt = 'Picture of Simple Computer']"));
            Assertions.assertTrue(element3.isDisplayed(),String.format("Элемента %s нет на странице" ,element3));

            WebElement element4 = driver.findElement(By.xpath("//a[@href = '/jewelry']"));
            Assertions.assertTrue(element4.isDisplayed(),String.format("Элемента %s нет на странице" ,element4));

            WebElement element5 = driver.findElement(By.xpath("//label[@for = 'pollanswers-1']"));
            Assertions.assertTrue(element5.isDisplayed(),String.format("Элемента %s нет на странице" ,element5));

            WebElement element6 = driver.findElement(By.xpath("//div[@class = 'listbox']"));
            Assertions.assertTrue(element6.isDisplayed(),String.format("Элемента %s нет на странице" ,element6));

            WebElement element7 = driver.findElement(By.xpath("//*[@value = 'Add to cart']"));
            Assertions.assertTrue(element7.isDisplayed(),String.format("Элемента %s нет на странице" ,element7));

            WebElement element8 = driver.findElement(By.xpath("//a[@href = '/gift-cards']"));
            Assertions.assertTrue(element8.isDisplayed(),String.format("Элемента %s нет на странице" ,element8));

            WebElement element9 = driver.findElement(By.xpath("//span[@class = 'cart-label']"));
            Assertions.assertTrue(element9.isDisplayed(),String.format("Элемента %s нет на странице" ,element9));
        }

        @AfterEach
        public void afterVoid() {
            driver.quit();
        }
    }


