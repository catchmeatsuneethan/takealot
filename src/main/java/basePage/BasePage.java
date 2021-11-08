package basePage;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class BasePage {

    public static WebDriver driver;
    public JavascriptExecutor js = (JavascriptExecutor) driver;

    protected WebElement find(By locator) {
        setWait(10);
        return driver.findElement(locator);
    }

    protected void type(String text, By locator) {
        find(locator).sendKeys(text);
    }

    protected void clear(By locator) {
        find(locator).clear();
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void click(WebElement locator) {
        locator.click();
    }


    protected List<WebElement> findElements(By locator) {
        setWait(10);
        return driver.findElements(locator);
    }

    protected void setWait(int durationSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(durationSeconds));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.ignoring(NoSuchElementException.class);
    }

    protected void waitForPageToLoad(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void clickAction(WebElement element) {
        Actions action = new Actions(driver);

        action.moveToElement(element).click().build().perform();
    }

    public void doubleClickAction(WebElement element) {
        Actions action = new Actions(driver);

        action.moveToElement(element).doubleClick().build().perform();
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    protected boolean isElementPresent(By locator) {
        try {
            find(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
