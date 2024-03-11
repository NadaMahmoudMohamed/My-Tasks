package pages.WebTask;

import base.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class OrderCheckingOut extends PageObjectBase {

    public static By THINKING_IN_HTML_BOOK = By.id("XX");
    public static By CART = By.id("CC");
    public static By ADD_TO_BASKET_BUTTON = By.id("NN");
    public static By CHECK_OUT_BUTTON = By.id("CH");
    public static By BILLING_FORM = By.id("CH");

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
        clickOnElement((WebElement) ADD_TO_BASKET_BUTTON);
    }
}
