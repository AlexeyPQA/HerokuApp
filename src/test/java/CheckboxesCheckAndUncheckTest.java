import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesCheckAndUncheckTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void CheckboxesCheckAndUncheck() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        boolean firstcheckbox = driver.findElement(By.cssSelector("[type=checkbox")).isSelected();
        Assert.assertFalse(firstcheckbox);

        driver.findElement(By.cssSelector("[type=checkbox")).click();
        boolean firstcheckboxs1 = driver.findElement(By.cssSelector("[type=checkbox")).isSelected();
        Assert.assertTrue(firstcheckboxs1);

        boolean secondcheckbox = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).isSelected();
        Assert.assertTrue(secondcheckbox);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click();
        boolean secondcheckboxs1 = driver.findElement(By.cssSelector("[type=checkbox")).isSelected();
        Assert.assertTrue(secondcheckboxs1);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
