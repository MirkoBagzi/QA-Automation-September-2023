package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LimundoSearchResultsPage;
import pages.LimundoWelcomePage;

import java.util.List;

public class LimundoFilterSearchResultsTest extends BaseTest {
    @Test
    public void LimundoFilterSearchResultsTest() throws InterruptedException {
        String url = "https://www.limundo.com/";
        String searchTerm = "Iphone";
        String searchCategoryName = "Mobilni telefoni";
        String filterName = "Cena";
        String odCijena = "50";
        String doCijena = "100";
        int numberOdCijena = Integer.parseInt(odCijena);

        LimundoWelcomePage searchOnWelcomePage = new LimundoWelcomePage(driver);
        searchOnWelcomePage.searchLimundo(url, searchTerm);

        LimundoSearchResultsPage selectArticles = new LimundoSearchResultsPage(driver);
        selectArticles.selectArticlesWithinPriceRange(searchCategoryName, filterName, odCijena, doCijena);

        WebElement filterResults = driver.findElement(By.className("list-view-listing"));
        List<WebElement> results = filterResults.findElements(By.className("list-view-listing-item"));

        for (WebElement result : results) {
            String title = result.findElement(By.tagName("h3")).getText();
            WebElement price = result.findElement(By.tagName("strong"));
            String stringPrice = price.getText();

//            System.out.println(stringPrice);

            String priceFixed = stringPrice.replace(" RSD", "");

//            System.out.println(priceFixed);

            int numberPrice = Integer.parseInt(priceFixed);

            softAssertion.assertTrue(numberPrice >= numberOdCijena && numberPrice <= Integer.parseInt(doCijena),
                    "Cijena artikla je: \"" + numberPrice + "\". Cijena nije u trazenom opsegu izmedju " + numberOdCijena + " i " + doCijena);

            softAssertion.assertTrue(title.toLowerCase().contains(searchTerm.toLowerCase()),
                    "Trazeni pojam: \"" + searchTerm + "\" se ne nalazi u naslovu artikla: \"" + title + "\"");
        }
        softAssertion.assertAll();

        Thread.sleep(6000);
    }
}
