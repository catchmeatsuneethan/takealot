package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class AddToCart extends BasePage {
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    private String ClickOnBasketButton= "document.querySelector(\"#shopfront-app > div.top-nav.top-nav-module_top-nav_2cmJW > div > div > div.auto.cell > div > div.shrink.cell > div > div > div > div > button\").click();";
    private String productTitleInTheBasket= "return document.querySelector(\"#shopfront-app > div.grid-container.cart.cart-content-module_cart_3W93Z > div.grid-x.cart-content-module_cart-container_1ucKG > section > div:nth-child(2) > div.cell.auto > div:nth-child(1) > div > div > article > div > div > div.cell.auto > div > div:nth-child(1) > div > div.cell.small-12.medium-auto > div:nth-child(1)\").innerText";
    private String clickOnAddToCartButton= "document.querySelector(\"#shopfront-app > div.pdp.pdp-module_pdp_1CPrg > div.grid-container.pdp-grid-container > div:nth-child(2) > aside > div.pdp-module_sidebar-buybox_1m6Sm > div.buybox-actions-container.buybox-module_buybox-actions_2g4b2 > div > div > div.buybox-actions-module_button-cell_2dQyM.buybox-actions-module_add-to-cart-cell_3fXyS > a\").click();";


    public void addProductTOCart(String product) throws InterruptedException {
        searchResultsPage.searchForSpecific(product);
        WebElement el = searchResultsPage.verifyProductExists(product);
        clickAction(el);
        waitForPageToLoad(120);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(2000);
        js.executeScript(clickOnAddToCartButton);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    public String verifyProductExistsInBasket() throws InterruptedException {
       js.executeScript(ClickOnBasketButton);
        Thread.sleep(2000);
        String productTitle= (String) js.executeScript(productTitleInTheBasket);
        return productTitle;
    }

    public int verifyQuantityExistsInBasket() throws InterruptedException {
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"cart-item_undefined\"]")));
        WebElement option = select.getFirstSelectedOption();
        return Integer.parseInt(option.getText());
    }
}
