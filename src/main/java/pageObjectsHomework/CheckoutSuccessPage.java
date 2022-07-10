package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    public WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private By pageCompleteTitle = By.cssSelector("span[class='title']");

    public WebElement getPageCompliteTitle(){
        return driver.findElement(pageCompleteTitle);
    }
    private By thankYouText = By.cssSelector("h2[class='complete-header']");

    public WebElement getThankYouText(){
        return driver.findElement(thankYouText);
    }

    private By backHomeButton = By.id("back-to-products");

    public WebElement getBackHomeButton(){
        return driver.findElement(backHomeButton);
    }

}
