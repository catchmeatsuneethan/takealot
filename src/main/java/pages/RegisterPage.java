package pages;

import basePage.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterPage extends BasePage {

    private final By firstNameTextBox = By.id("firstname");
    private final By lastNameTextBox = By.id("surname");
    private final By emailTextBox = By.id("email");
    private final By reTypeEmailTextBox = By.id("email2");
    private final By passwordTextBox = By.id("password");
    private final By reTypePasswordTextBox = By.id("password2");
    private final By mobileNoTextBox = By.id("telno1");
    private final By registerButton = By.name("registerButton");
    private final By registerLink = By.linkText("Register");
    private final String registerPageTitle = "Register on Takealot | takealot.com";
    private final By welcomeFrameClickHereToContinue = By.xpath("//*[@id=\"welcome\"]/p[2]/a");
    private final By welcomeBanner = By.xpath("//body/div[@id='shopfront-app']/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]");
    private final By logoutButton = By.xpath("//*[@id='shopfront-app']/div[3]/div/div/div[2]/div/div[1]/ul/li[2]/form/button");


    private String firstName = generateRandomString(8);
    private String lastName = generateRandomString(6);
    private String emailAddress = generateEmail(8);
    private final String password = "Tester1@";
    private final String mobileNo="07700900650"; // fake mobile number generated online

    /*  random values in the registration screen text boxes */
    public void createANewUser()  {
        navigateRegistrationPage();
        type(firstName, firstNameTextBox);
        type(lastName, lastNameTextBox);
        type(emailAddress, emailTextBox);
        type(emailAddress, reTypeEmailTextBox);
        type(password, passwordTextBox);
        type(password, reTypePasswordTextBox);
        type(mobileNo, mobileNoTextBox);
        click(registerButton);
        waitForPageToLoad(20);
    }

    public void navigateRegistrationPage() {
        click(registerLink);
        driver.getTitle().contains(registerPageTitle);
    }

    /*verifying user is created by checking logout button exists and firstname matches on navbar screen*/
    public boolean verifyUserIsCreated() {
        click(welcomeFrameClickHereToContinue);
        String navModuleHeader=find(welcomeBanner).getText();  //retrieve the element text from nav bar
        String parts[] = navModuleHeader.split(Pattern.quote("("));
        String firstPart = parts[0];
        String nameOnBanner[] = firstPart.split(" ", 2);  //strip the characters
        assertEquals(nameOnBanner[1],firstName); //verifying the firstname matches the nav bar Name
       assertTrue(find(logoutButton).isDisplayed());  //checking logout button exists proves user is registered/logged in
        return true;
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String generateEmail(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
                "1234567890"; // numbers
        String email = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp + "@mailinator.com";
        return email;
    }
}
