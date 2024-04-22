package homeWork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


    public class FindElementsByXpathTest extends BaseTest {

        @BeforeEach
        void start() {
            driver.get(BaseTest.url_demowebshop);
        }

        @Test
        public void findElementByXpath(){
            WebElement element1 = driver.findElement(By.xpath("//h2"));
            Assertions.assertTrue(element1.isDisplayed(),String.format ("Элемент по xpath не отображается на странице",element1));

            WebElement element2 = driver.findElement(By.xpath("/html/body/div[4]/div[1]"));
            Assertions.assertTrue(element2.isDisplayed(),String.format ("Элемент по xpath не отображается на странице",element2));

            WebElement element3 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]"));
            Assertions.assertTrue(element3.isDisplayed(),String.format ("Элемент по xpath не отображается на странице",element3));

            WebElement element4= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/a"));
            Assertions.assertTrue(element4.isDisplayed(),String.format ("Элемент по xpath не отображается на странице",element4));

            WebElement element5= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[1]/div[1]"));
            Assertions.assertTrue(element5.isDisplayed(),String.format ("Элемент по xpath не отображается на странице",element5));

            WebElement element6= driver.findElement(By.xpath("/html/body/div[4]"));
            Assertions.assertTrue(element6.isDisplayed(),String.format ("Элемент по xpath не отображается на странице",element6));


            WebElement element7= driver.findElement(By.xpath("/html/body/div[4]/div[1]"));
            Assertions.assertTrue(element7.isDisplayed(),String.format ("Элемент по xpath не отображается на странице",element7));


            WebElement element8= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]"));
            Assertions.assertTrue(element8.isDisplayed(),String.format ("Элемент по xpath не отображается на странице",element8));

            WebElement element9= driver.findElement(By.xpath("/html/body/div[4]/div[2]"));
            Assertions.assertTrue(element9.isDisplayed(),String.format ("Элемент по xpath не отображается на странице",element9));

            WebElement element10= driver.findElement(By.xpath("/html/body/div[4]/div[2]"));
            Assertions.assertTrue(element10.isDisplayed(),String.format ("Элемент по xpath не отображается на странице",element10));

        }

    }


