package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjectsHomework.*;

import java.time.Duration;

public class ElevenHomeworkStepDefinitions {
    WebDriver driver;
    pageObjectsHomework.LoginPage loginPage;

    @Before("@browser")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @After("@browser")
    public void tearDown(){
        driver.close();
    }

    @Given("user is navigated to page {string}")
    public void userIsNavigatedTo(String url) {
        driver.get(url);
    }

    @When("user enters login {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.getUsernameField().sendKeys((username));
        loginPage.getPasswordField().sendKeys(password);
    }

    @And("user clicks button to login")
    public void userClicksLoginButton() {
        loginPage.getLoginButton().click();
    }

    @When("user sees item {string}")
    public void userSeesItem(String itemTitle) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getItemName().getText(), itemTitle);
    }

    @And("user clicks checkout button")
    public void userClicksCheckoutButton() {
        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();
    }

    @When("user enter name {string} and lastname {string} and zip {string}")
    public void userEnterNameLastnameZip(String name, String lastname, String zip) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.insertData(name, lastname, zip);
    }

    @And("user clicks continue button")
    public void userClicksContinueButton() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getContinueButton().click();
    }

    @When("checkout data is correct")
    public void checkoutDataIsCorrect() {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getOverviewTitle().getText(), "CHECKOUT: OVERVIEW");
        Assert.assertEquals(checkoutOverviewPage.getInventoryItemName().getText(), "Sauce Labs Onesie");
    }

    @When("user clicks finish button")
    public void userClicksFinishButton() {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.getFinishButton().click();
    }

    @Then("order is created successfully")
    public void orderIsCreatedSuccessfully() {
        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getPageCompliteTitle().getText(), "CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkoutSuccessPage.getThankYouText().getText(), "THANK YOU FOR YOUR ORDER");
        checkoutSuccessPage.getBackHomeButton().click();
    }


    @Then("users sees error message {string}")
    public void usersSeesErrorMessageErrors_text(String errorMessage) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertEquals(checkoutPage.getErrorMessageHomework().getText(), errorMessage);
    }



}
