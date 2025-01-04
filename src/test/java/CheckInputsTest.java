import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckInputsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void CheckInputs() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        String arrowDownResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(arrowDownResult, "-3");

        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP);
        String arrowUpResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(arrowUpResult, "4");

        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("555");
        String keysResults = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(keysResults, "555");

        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("zzz");
        String charResults = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(charResults, "");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();}
}
