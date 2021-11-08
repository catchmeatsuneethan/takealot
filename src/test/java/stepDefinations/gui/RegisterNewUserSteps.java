package stepDefinations.gui;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegisterNewUserSteps {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Given("As a user I am on the takealot.com Homepage")
    public void verifyUserIsOnHomePage() {

        homePage.userIsOnHomepage();
    }

    @When("I register as a new user")
    public void registerNewUser()  {

        registerPage.createANewUser();
    }

    @When("verify a new user is created")
    public void verifyUserIsCreated() {

        assertTrue(registerPage.verifyUserIsCreated());
    }


}
