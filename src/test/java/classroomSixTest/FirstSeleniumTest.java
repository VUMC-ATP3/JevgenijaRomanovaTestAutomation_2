package classroomSixTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver chromeParluks;


    @Test
    public void testPageTitle(){
        chromeParluks = new ChromeDriver();
        chromeParluks.navigate().to("https://edu.lu.lv/mod/assign/view.php?id=75075");
        chromeParluks.manage().window().maximize();
        String expectedTitle = "AUTOMATIZĒTA PROGRAMMATŪRAS TESTĒŠANA";
        String actualTitle = chromeParluks.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        chromeParluks.quit();


    }
    @AfterMethod
    public void closeBrowser(){
        chromeParluks.quit();
    }
}
