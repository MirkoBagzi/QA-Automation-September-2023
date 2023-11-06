package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BlicHomePage;

import java.util.List;

public class BlicSearchAssertAllResultsTest extends BaseTest {

    @Test
    public void searchBlic() throws InterruptedException {
        String url = "https://www.blic.rs/";
        String searchTerm = "Veselin Jevrosimović";


        BlicHomePage blicSearch = new BlicHomePage(driver);
        blicSearch.searchBlicTest(url, searchTerm);


        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("news-box")));
        WebElement searchResults = driver.findElement(By.className("news-box"));

        List<WebElement> results = searchResults.findElements(By.tagName("article"));

        for(WebElement article : results){
            WebElement articleTitle = article.findElement(By.tagName("h2"));
            String title = articleTitle.getText();
            if(title.contains(searchTerm)){
                System.out.println(title);//ispisuje sve naslove koji imaju trazeni pojam
            }
            softAssertion.assertTrue(title.contains(searchTerm), "Search Term: \"" + searchTerm + "\" is NOT present in headline: \n" + title);
        }

        softAssertion.assertAll();//potrebno da bi zaista odradili assert, odnosno da provjeri da li ima ijedna vrijednost false u listi koju pravi gornji assertTrue

        Thread.sleep(5000);

    }
}
