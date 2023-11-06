package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.OlxHomePage;

import java.util.List;

public class OlxAssertAllSearchResultsTest extends BaseTest {
    @Test
    public void searchFilterTest() throws InterruptedException {
        String url = "https://olx.ba/";
        String searchTerm = "Renault Scenic";

        OlxHomePage homePage = new OlxHomePage(driver);
        homePage.searchOlx(url, searchTerm);

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("artikli")));
        WebElement searchResults = driver.findElement(By.className("artikli"));
        List<WebElement> results = searchResults.findElements(By.className("cardd"));

        for (WebElement result : results) {
            String title = result.findElement(By.tagName("h1")).getText();
            softAssertion.assertTrue(title.toUpperCase().contains(searchTerm.toUpperCase()), "Article: \n" + title + "\n does NOT contain Search Term in the tittle!");
        }
        softAssertion.assertAll();

        //result[0]:true : null
        //result[1]:false : porukica + expected [true] but found [false]
        //result[2]:false : porukica + expected [true] but found [false]
        //result[3]:true : null
        Thread.sleep(6000);
    }


}
