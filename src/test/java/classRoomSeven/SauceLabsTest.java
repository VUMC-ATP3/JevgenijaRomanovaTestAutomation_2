package classRoomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Footer;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

import java.util.List;

public class SauceLabsTest {
    WebDriver driver;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";
    private final String LOCAL_URL = "file://C:\\Users\\Guest1234\\Desktop\\TestAutomation\\JevgenijaRomanovaTestAutomation_2\\elements.html";


    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Atveram browseri");

    }

    @Test
    public void testErrorMessage() throws InterruptedException {
        driver.get(SWAGLABS_URL);

        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("");

        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Password is required";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        Thread.sleep(5000);
        System.out.println("Izpildam testu");

    }

    @Test
    public void testErrorMessageWithPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameField().sendKeys("standard_user");
        loginPage.getPasswordField().sendKeys("");
        loginPage.getLoginButton().click();
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }

    @Test
    public void testErrorMessageWithoutPasswordPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","");
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }

    @Test
    public void testErrorMessageWithoutUsernameWPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "parole");
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }

    @Test
    public void testSuccessLogin(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle().getText(),"PRODUCTS");

    }

    @Test
    public void testFooterCopyRightText(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Footer footer = new Footer(driver);
        String actualString = footer.getCopyRightTextField().getText();
        String expectedString = "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
        Assert.assertEquals(actualString, expectedString);

    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        driver.get(SWAGLABS_URL);

        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement titleText = driver.findElement(By.cssSelector("span[class='title']"));
        Assert.assertEquals(titleText.getText(), "PRODUCTS");

        WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));

        //linkedInLink.click();

        Select sortDropDown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropDown.selectByValue("hilo");

        WebElement addFleeceJacketToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        addFleeceJacketToCartButton.click();






        Thread.sleep(5000);


    }

    @Test
    public void testSamplePage() throws InterruptedException {
     driver.get(LOCAL_URL);
     WebElement vards = driver.findElement(By.id("fNameID"));
     vards.sendKeys("Jevgenija");

     WebElement uzvards = driver.findElement(By.id("lNameID"));
     uzvards.sendKeys("Romanova");

     WebElement informacija = driver.findElement(By.name("description"));
     informacija.clear();
     informacija.sendKeys("Šī ir info par mani");

     WebElement studentChecbox = driver.findElement(By.id ("studentID"));
     studentChecbox.click();

     WebElement radioButtonJava = driver.findElement(By.id("javaID"));
     System.out.println(radioButtonJava.isSelected());
     radioButtonJava.click();
     System.out.println(radioButtonJava.isSelected());

     Select milakaKrasaDropdown = new Select(driver.findElement(By.id("colorsID")));
     milakaKrasaDropdown.selectByIndex(0);
     milakaKrasaDropdown.selectByIndex(1);

        List<WebElement> saraksts = milakaKrasaDropdown.getOptions();

        for (int i = 0; i < saraksts.size(); i++) {
            System.out.println(saraksts.get(i).getText());
        }


        Thread.sleep(5000);

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        System.out.println("Aizveram browseri");

    }
}
