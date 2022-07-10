package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By itemName = By.cssSelector("div[class='inventory_item_name']");
    private By checkoutButton = By.id("checkout");

    public WebElement getItemName(){
        return driver.findElement(itemName);
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }
}
