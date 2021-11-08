package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    public String actualProductTitle;
    private List<WebElement> productTitleName;
    private final By searchBox = By.name("search");
    private final By searchBrandBox = By.id("_undefined");
    private final By searchButton = By.className("input-group-button");
    private final By searchBrandResult = By.xpath("//div[@id='scroll-container']");
    private final String loadMoreButton = "document.querySelector(\"#shopfront-app > div.grid-container.search-listings-module_search-listings_2Lw_d > div > div.cell.auto > div.search-listings-module_load-more-container_2sgBB > button\")";
    private final String clickLoadMoreButton = "document.querySelector(\"#shopfront-app > div.grid-container.search-listings-module_search-listings_2Lw_d > div > div.cell.auto > div.search-listings-module_load-more-container_2sgBB > button\").click()";
    private final String brandCheckbox = "document.querySelector('#scroll-container > div > div:nth-child(1) > ul > div > div > li > label').click();";
    private final String cookieOKButton = "document.querySelector('#shopfront-app > div.header-module_bottom-banners-container_3F8RC > div > button').click();";
    private final String productTitles = "return document.querySelector('#shopfront-app > div.grid-container.search-listings-module_search-listings_2Lw_d > div > div.cell.auto > div.listings-container.listings-container-module_listings-container_AC4LI > div').getElementsByClassName('product-title')";


    public void searchFor(String product) {
        type(product, searchBox);
        click(searchButton);
        waitForPageToLoad(60);
    }

    public void SearchForBrand(String brandName) {
        type(brandName, searchBrandBox);
        if (find(searchBrandResult).getText().equalsIgnoreCase(brandName))
            js.executeScript(brandCheckbox);
        waitForPageToLoad(60);
    }

    public List<WebElement> searchForSpecific(String productName) throws InterruptedException {
        clear(searchBox);
        type(productName, searchBox);
        waitForPageToLoad(120);
        js.executeScript(cookieOKButton);
        click(searchButton);

        boolean loadMore = false;
        do {
            if (!(js.executeScript(loadMoreButton)==null)) {

                js.executeScript(clickLoadMoreButton);
                loadMore = true;
            }else {

                loadMore = false;
            }
        } while (loadMore);

        Thread.sleep(3000);

        return productTitleName = (List<WebElement>) js.executeScript(productTitles);


    }


    public WebElement verifyProductExists(String productName) {
        productTitleName = (List<WebElement>) js.executeScript(productTitles);
        System.out.println(productTitleName.size() + " Elements found by product-title \n");

        for (int i = 0; i < productTitleName.size(); i++) {

            System.out.println(productTitleName.get(i).getText() + "  ...product title matches from web");

            if (productName.equals(productTitleName.get(i).getText())) {

                actualProductTitle = productTitleName.get(i).getText();/*if the product exists then it will assign to the global variable*/

                System.out.println(actualProductTitle + "  ...product title");

                return productTitleName.get(i);
            }
        }
        return null;
    }
}
