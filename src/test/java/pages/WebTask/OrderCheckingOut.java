package pages.WebTask;

import base.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class OrderCheckingOut extends PageObjectBase {

    public static By THINKING_IN_HTML_BOOK = By.name("Thinking in HTML");
    public static By CART = By.id("wpmenucartli");
    public static By ADD_TO_BASKET_BUTTON = By.className("button product_type_simple add_to_cart_button ajax_add_to_cart");
    public static By CHECK_OUT_BUTTON = By.className("checkout-button button alt wc-forward");
    public static By BILLING_FORM = By.id("customer_details");

    public OrderCheckingOut() throws MalformedURLException {
        super();
    }

    public boolean billingDetailsFormIsDisplayed() {
        return elementDisplayed((WebElement) BILLING_FORM);
    }

    public void clickOnProceedToCheckOut() {
        clickOnElement((WebElement) CHECK_OUT_BUTTON);
    }

    public boolean thinkingInHTMLBookIsExisted() {
        return elementDisplayed((WebElement) THINKING_IN_HTML_BOOK);
    }

    public void clickOnShoppingCart() {
        clickOnElement((WebElement) CART);
    }

    public void clickOnAddBookToBasket() {
        ((WebElement) ADD_TO_BASKET_BUTTON).findElement(By.partialLinkText("/?add-to-cart=163")).click();
    }
}
