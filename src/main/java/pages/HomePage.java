package pages;

import basePage.BasePage;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class HomePage extends BasePage {

    private final String homePageTitle = "Takealot.com: Online Shopping | SA's leading online store";


    public void userIsOnHomepage() {
        waitForPageToLoad(60);
        driver.getTitle().contains(homePageTitle);
    }
}

