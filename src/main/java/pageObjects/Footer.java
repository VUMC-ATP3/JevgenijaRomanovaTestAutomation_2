package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {
    public WebDriver driver;

    public Footer(WebDriver driver) {
        this.driver = driver;
    }

    private By twitterLinkt = By.linkText("Twitter");
    private By fbLink = By.linkText("Facebook");
    private By linkedInLink = By.linkText("LinkedIn");
    private By copyRightText = By.cssSelector("div[class='footer_copy']");

    public WebElement gettwitterLinkField() {
        return driver.findElement(twitterLinkt);
    }

    public WebElement getfbLinkField() {
        return driver.findElement(fbLink);
    }

    public WebElement getCopyRightTextField() {
        return driver.findElement(copyRightText);
    }

}
