package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    public WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By pageProductsTitle = By.cssSelector("span[class='title']");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-onesie");
    private By cartBadgeButton = By.cssSelector("a[class='shopping_cart_link']");



    public WebElement getPageTitle(){
        return driver.findElement(pageProductsTitle);
    }

    public WebElement getAddToCartButton(){
        return driver.findElement(addToCartButton);
    }

    public WebElement getCartBadgeButton(){
        return driver.findElement(cartBadgeButton);
    }

    public void addToCart(){
        getAddToCartButton().click();
    }

    public void openCart(){
        getCartBadgeButton().click();
    }
}
