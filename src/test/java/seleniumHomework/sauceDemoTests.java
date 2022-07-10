package seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

public class sauceDemoTests {
    WebDriver driver;
    public final String SWAGLABS_URL = "https://www.saucedemo.com/";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testOne() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
        inventoryPage.addToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getItemName().getText(), "Sauce Labs Onesie");
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.insertData("Jevgenija", "Romanova", "LV-2164");
        checkoutPage.getContinueButton().click();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getOverviewTitle().getText(),"CHECKOUT: OVERVIEW");
        Assert.assertEquals(checkoutOverviewPage.getInventoryItemName().getText(),"Sauce Labs Onesie");
        checkoutOverviewPage.getFinishButton().click();

        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getPageCompliteTitle().getText(),"CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkoutSuccessPage.getThankYouText().getText(),"THANK YOU FOR YOUR ORDER");
        checkoutSuccessPage.getBackHomeButton().click();
    }


    @Test
    public void testTwo()  {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorFirstName().getText(), "Error: First Name is required");

        checkoutPage.insertData("Jevgenija","","");
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorLastName().getText(),"Error: Last Name is required");

        checkoutPage.insertData("","Romanova","");
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorZipPostalCode().getText(),"Error: Postal Code is required");

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();

    }
}
