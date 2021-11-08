package stepDefinations.gui;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.junit.Assert;
import pages.AddToCart;

import static org.junit.Assert.assertEquals;

public class Basket {

    AddToCart addToCart = new AddToCart();

    @And("^I add the \"([^\"]*)\" to basket$")
    public void iAddedTheToBasket(String product) throws Throwable {

            addToCart.addProductTOCart(product);
    }

    @And("^I verify the \"([^\"]*)\" is added in the basket$")
    public void iVerifyTheIsAddedInTheBasket(String productName) throws Throwable {

        assertEquals(productName,addToCart.verifyProductExistsInBasket());

    }


    @And("^I verify the qty is (\\d+) on the basket$")
    public void iVerifyTheOnTheBasket(int qty) throws InterruptedException {

        assertEquals(qty,addToCart.verifyQuantityExistsInBasket());

    }
}
