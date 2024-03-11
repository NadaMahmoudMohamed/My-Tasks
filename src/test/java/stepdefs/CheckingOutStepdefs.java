package stepdefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebTask.OrderCheckingOut;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckingOutStepdefs {
    private OrderCheckingOut orderCheckingOut;

    public CheckingOutStepdefs() throws MalformedURLException {
        orderCheckingOut = new OrderCheckingOut();
    }

    @Then("Thinking in HTML book is existed")
    public void thinkingInHTMLBookIsExisted() {
        assertTrue(orderCheckingOut.thinkingInHTMLBookIsExisted());
    }

    @Given("User clicks on add the book to basket")
    public void userClicksOnAddTheBookToBasket() {
        orderCheckingOut.clickOnAddBookToBasket();
    }

    @And("User clicks on shopping cart")
    public void userClicksOnShoppingCart() {
        orderCheckingOut.clickOnShoppingCart();
    }

    @Then("Book added to cart with its details")
    public void bookAddedToCartWithItsDetails() {
        assertTrue(orderCheckingOut.thinkingInHTMLBookIsExisted());
    }

    @When("User clicks on proceed to checkout")
    public void userClicksOnProceedToCheckout() {
        orderCheckingOut.clickOnProceedToCheckOut();
    }

    @Then("Billing details form is displayed")
    public void billingDetailsFormIsDisplayed() {
        assertTrue(orderCheckingOut.billingDetailsFormIsDisplayed());
    }
}
