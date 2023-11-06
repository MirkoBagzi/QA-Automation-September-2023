package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OlxSearchTest extends BaseTest{

    @Test
    public void searchOlx() throws InterruptedException {
        String searchTerm = "Renault Scenic";

        //1. Navigate to "https://olx.ba/"
        driver.get("https://olx.ba/");

        //2. In search input field type search term e.g. "Renault Scenic"
        WebElement searchInputField = driver.findElement(By.name("notASearchField"));
        searchInputField.sendKeys(searchTerm);

        //3. Click on search button with label "Pogledaj sve rezultate" within search container
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("searchbar-dropdown")));
        WebElement searchContainer = driver.findElement(By.className("searchbar-dropdown"));
        WebElement searchButton = searchContainer.findElement(By.tagName("button"));
        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        //4. Assert search results
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("artikli")));
        WebElement searchResults = driver.findElement(By.className("artikli"));
        Assert.assertTrue("Search term is not present within results.", searchResults.getText().contains(searchTerm));


        Thread.sleep(3000);

    }
}
