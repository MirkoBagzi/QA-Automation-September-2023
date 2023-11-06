package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BlicHomePage;
import pages.BlicSearchResultsPage;

public class BlicSearchOpenArticlePOMTest extends BaseTest {

    @Test
    public void searchBlic() throws InterruptedException {
        String url = "https://www.blic.rs/";
        String searchTerm = "Veselin Jevrosimović";
        int articleNumber = 7;


        BlicHomePage blicSearch = new BlicHomePage(driver);
        blicSearch.searchBlicTest(url, searchTerm);

        BlicSearchResultsPage searchResults = new BlicSearchResultsPage(driver);
        searchResults.clickOnRequestedArticle(articleNumber);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("article")));
        WebElement article = driver.findElement(By.className("article"));
        WebElement articleHeader = article.findElement(By.tagName("h1"));

        Assert.assertTrue("Search Term: \"" + searchTerm + "\" is NOT present in headline: \n" + articleHeader.getText(),
                articleHeader.getText().toLowerCase().contains(searchTerm.toLowerCase()));

        Thread.sleep(5000);

    }
}
