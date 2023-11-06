package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlicSearchTest extends BaseTest {
    @Test
    public void searchBlic() throws InterruptedException {
        String searchTerm = "Veselin Jevrosimović";

        //1. Navigate to "https://www.blic.rs/"
        driver.get("https://www.blic.rs/");

        //2. In search input field type search term e.g. "Veselin Jevrosimović"
        WebElement searchInputField = driver.findElement(By.id("search-input"));
        searchInputField.sendKeys(searchTerm);

        //3. Click on magnifier button within search container
        WebElement searchContainer = driver.findElement(By.id("search"));
        WebElement searchButton = searchContainer.findElement(By.tagName("button"));
        searchButton.click();

        //4. Assert search results
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("news-box")));
        WebElement searchResults = driver.findElement(By.className("news-box"));
        Assert.assertTrue("Search term is not present within results.", searchResults.getText().contains(searchTerm));


        Thread.sleep(3000);

    }
}
