package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MajasLapa {
    WebDriver chromeParluks;

    @Test
    public void testPageTitle(){
        chromeParluks = new ChromeDriver();
        chromeParluks.navigate().to("https://www.delfi.lv/");
        chromeParluks.manage().window().maximize();
        String expectedTitle = "DELFI - Vadošais ziņu portāls Latvijā - DELFI";
        String actualTitle = chromeParluks.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        chromeParluks.quit();
    }

    @Test
    public void testPageTitleTwo(){
        chromeParluks = new ChromeDriver();
        chromeParluks.navigate().to("https://www.circlek.lv/");
        chromeParluks.manage().window().maximize();
        String expectedTitle = "Circle";
        String actualTitle = chromeParluks.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        chromeParluks.quit();
    }

    @AfterMethod
    public void closeBrowser(){
        chromeParluks.quit();
    }
}
