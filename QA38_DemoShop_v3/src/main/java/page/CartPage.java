//package page;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import page.BasePage;
//
//import java.util.List;
//
//public class CartPage extends BasePage {
//    void clickOnShoppingCartLink() {
//        clickOnElement(By.xpath("//a[@href='/cart']"));
//    }
//
//    //    public static final String CART_QUANTITY = "//span[@class='cart-qty']";
//
//    protected boolean checkElementIsInCart() {
//        WebElement cartQtyElement = getElement(By.cssSelector(".page-body"));
//        List<WebElement> cartFormElements = cartQtyElement.findElements(By.xpath("//form[@action='/cart']"));
//        return !cartFormElements.isEmpty();
//    }
//
//    //    protected int getCartQuantity() {
////        WebElement cartQtyElement = getElement(By.xpath(CART_QUANTITY));
////        String cartQtyText = cartQtyElement.getText().replaceAll("\\D", "");
////        return Integer.parseInt(cartQtyText);
////    }
////
////    protected void verifyCartQuantityIncreased(int initialQuantity) {
////        int currentQuantity = getCartQuantity();
////        Assertions.assertEquals(initialQuantity + 1, currentQuantity,
////                "Expected cart quantity to increase by 1, but actual quantity is: " + currentQuantity);
////    }
//
//
//}
