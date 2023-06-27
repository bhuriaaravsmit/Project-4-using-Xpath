package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test

    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {

        //Enter the Username and password Field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Find the password Field and Enter the password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Click on Login Button

        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        String expectedText = "Products";
        String actualText = driver.findElement(By.className("title")).getText();
        System.out.println(expectedText);
        Assert.assertEquals("Verify the Text", expectedText, actualText);

    }

    @Test

    public void verifyThatSixProductsAreDisplayedOnPage() {

        //Enter the Username and password Field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Find the password Field and Enter the password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Click on Login Button

        driver.findElement(By.xpath("//input[@id='login-button']")).click();
            List<WebElement> elementList = driver.findElements(By.className("inventory_item"));
            System.out.println("Total Products are " + elementList.size());

    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}

