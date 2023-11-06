package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.YahooHomePage;

public class YahooSearchTest extends BaseTest {
    @Test
    public void searchYahooTest() {
        String url = "https://www.yahoo.com/";
        String searchTerm = "Q Station";

        YahooHomePage searchYahoo = new YahooHomePage(driver);
        searchYahoo.searchYahoo(url, searchTerm);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("results")));
        WebElement rezultati = driver.findElement(By.id("results"));

        Assert.assertTrue("Trazeni pojam se ne nalazi u rezultatima pretrage.",
                rezultati.getText().contains(searchTerm));
    }


}
