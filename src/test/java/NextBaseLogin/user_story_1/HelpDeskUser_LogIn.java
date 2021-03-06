package NextBaseLogin.user_story_1;

import Utilities.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HelpDeskUser_LogIn {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
       driver = WebDriverFactory.getDriver("chrome");
       driver.get("https://login2.nextbasecrm.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
//UserUser  helpdesk36@cybertekschool.com

@Test (priority = 1)
    public void helpDeskUserAc1 () {
        //Valid UserName Valid Password
        WebElement username = driver.findElement(By.name("USER_LOGIN"));
        username.sendKeys("helpdesk36@cybertekschool.com" + Keys.ENTER);

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser" + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "(55) Portal";

      Assert.assertEquals(actualTitle,expectedTitle, "Title verification is failed");
    }

    @Test(priority = 2)
    public void helpDeskUserAc2 () {
        //invalid UserName Valid Password
        WebElement username = driver.findElement(By.name("USER_LOGIN"));
        username.sendKeys("invalidusername" + Keys.ENTER);

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser" + Keys.ENTER);

        WebElement errorText = driver.findElement(By.className("errortext"));
        System.out.println("errorText.isDisplayed() = " + errorText.isDisplayed());
    }

    @Test (priority = 3)
    public void helpDeskUserAc3 () {
        //valid UserName invalid Password
        WebElement username = driver.findElement(By.name("USER_LOGIN"));
        username.sendKeys("helpdesk36@cybertekschool.com" + Keys.ENTER);

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUsUS" + Keys.ENTER);

        WebElement errorText = driver.findElement(By.className("errortext"));
        System.out.println("errorText.isDisplayed() = " + errorText.isDisplayed());
    }

    @Test(priority = 4)
    public void helpDeskUserAc4 () {
        //invalid UserName invalid Password
        WebElement username = driver.findElement(By.name("USER_LOGIN"));
        username.sendKeys("invalidinvalid" + Keys.ENTER);

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("invalid" + Keys.ENTER);

        WebElement errorText = driver.findElement(By.className("errortext"));
        System.out.println("errorText.isDisplayed() = " + errorText.isDisplayed());
    }

}
