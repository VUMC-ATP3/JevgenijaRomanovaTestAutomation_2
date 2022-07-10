package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    public WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private By overviewTitle = By.cssSelector("span[class='title']");

    private By inventoryItemName = By.cssSelector("div[class='inventory_item_name']");



    public WebElement getOverviewTitle(){
        return driver.findElement(overviewTitle);
    }

    public WebElement getInventoryItemName(){
        return driver.findElement(inventoryItemName);
    }

    private By finishButton = By.id("finish");

    public WebElement getFinishButton(){
        return driver.findElement(finishButton);
    }


}
