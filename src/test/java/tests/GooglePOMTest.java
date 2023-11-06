package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GoogleHomePage;

public class GooglePOMTest extends BaseTest {

    @Test
    public void searchGoogle() throws InterruptedException {
        String searchTerm = "Q Station";

        GoogleHomePage googleStranica = new GoogleHomePage(driver);// ovde kreiramo objekat od klase GoogleHomePage
        googleStranica.search(searchTerm);// ovde pozivamo public metodu preko objekta koji smo napravili

        //Assert rezultata
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        WebElement results = driver.findElement(By.id("search"));
        Assert.assertTrue("Search term is not on results page!",results.getText().contains(searchTerm));

        Thread.sleep(5000);


    }

}
