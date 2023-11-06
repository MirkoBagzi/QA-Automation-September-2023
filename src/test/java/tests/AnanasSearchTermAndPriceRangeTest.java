package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AnanasHomePage;
import pages.AnanasResultsPage;

import java.util.List;

public class AnanasSearchTermAndPriceRangeTest extends BaseTest {
    @Test
    public void ananasSearchAndPriceCheck() throws InterruptedException {
        String url = "https://ananas.rs/";
        String searchTerm = "iphone";
        String mainCategory = "Telefoni i foto";
        String category = "Mobilni telefoni";
        String minPrice = "100000";
        String maxPrice = "150000";

        AnanasHomePage ananasHomePage = new AnanasHomePage(driver);
        ananasHomePage.searchInsertedTerm(url, searchTerm);

        AnanasResultsPage ananasResultsPage = new AnanasResultsPage(driver);
        ananasResultsPage.selectCategoryInsertPrice(mainCategory, category, minPrice, maxPrice);

        WebElement resultsContainer = wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ais-Hits-list")));
        List<WebElement> articlesList = resultsContainer.findElements(By.tagName("li"));

        for (WebElement article : articlesList) {
            WebElement priceElement = article.findElement(By.cssSelector(".sc-1arj7wv-8.fdvOja"));
            String priceElementText = priceElement.getText();
            String priceElementFixed = priceElementText.replace("\n", "").replace(" ", "").replace("RSD", "").replace(".", "");
            float price = Float.parseFloat(priceElementFixed);

            WebElement elementTittle = article.findElement(By.tagName("h3"));

            softAssertion.assertTrue(elementTittle.getText().toLowerCase().contains(searchTerm.toLowerCase()),
                    "Tittle doesn't contain requested Term.\nTittle is: " + elementTittle.getText() + "\nRequested term: " + searchTerm);
            softAssertion.assertTrue((price >= Float.parseFloat(minPrice) && price <= Float.parseFloat(maxPrice)),
                    "Price is not in selected range for article:" + elementTittle);
        }
        softAssertion.assertAll();

        Thread.sleep(5000);
    }
}
