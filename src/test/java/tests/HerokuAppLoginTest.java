package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HerokuAppLoginTest extends BaseTest {
    @Test
    public void loginWithValidCredentialsTest() {
        //introduce username & password
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        //1. Navigate to "https://the-internet.herokuapp.com/login"
        driver.get("https://the-internet.herokuapp.com/login");

        //2. In Username  input field type e.g. "tomsmith"
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        //3. In Password input field type e.g. "SuperSecretPassword!"
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        //4. Click on button with a label "Login"
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        //Assert valid login
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("success")));
        WebElement loginMessage = driver.findElement(By.className("success"));
        WebElement logOutButton = driver.findElement(By.className("icon-signout"));
        Assert.assertTrue("Error during logging in! No login message is shown!", loginMessage.getText().contains("You logged into a secure area!"));
        Assert.assertTrue("Logout Button is not shown!", logOutButton.isDisplayed());
    }

    @Test
    public void loginWithWrongPassword(){

    }

}
