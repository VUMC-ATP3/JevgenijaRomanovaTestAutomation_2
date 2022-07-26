package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");


    public WebElement getFirstName(){
        return driver.findElement(firstName);
    }

    public WebElement getLastName(){
        return driver.findElement(lastName);
    }

    public WebElement getPostalCode(){
        return driver.findElement(postalCode);
    }

    public WebElement getContinueButton(){
        return driver.findElement(continueButton);
    }

    public void insertData(String firstName, String lastname, String postalCode){
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastname);
        getPostalCode().sendKeys(postalCode);
    }

    private By errorFirstName = By.cssSelector("h3[data-test='error']");
    private By errorLastName = By.cssSelector("h3[data-test='error']");
    private By errorZipPostalCode = By.cssSelector("h3[data-test='error']");

    public WebElement getErrorFirstName(){
        return driver.findElement(errorFirstName);
    }
    public WebElement getErrorLastName(){
        return driver.findElement(errorLastName);
    }
    public WebElement getErrorZipPostalCode(){
        return driver.findElement(errorZipPostalCode);
    }

    private By errorMessageHomework = By.cssSelector("div[class='error-message-container error']");
    public WebElement getErrorMessageHomework(){
        return driver.findElement(errorMessageHomework);
    }
}
