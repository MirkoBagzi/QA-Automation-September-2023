package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OlxSearchOpenArticleTest extends BaseTest{

    @Test
    public void searchOlx() throws InterruptedException {
        String searchTerm = "Renault Scenic";
        int articleNumber = 13;

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

        //4. Open desired article
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("artikli")));
        WebElement searchResults = driver.findElement(By.className("articles"));
        List<WebElement> resultsList = searchResults.findElements(By.className("cardd"));
        WebElement article = resultsList.get(articleNumber - 1);
        WebElement articleTitle = article.findElement(By.tagName("h1"));
        String articleTitleString = articleTitle.getText();
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", articleTitle); //skrolovanje da nas element bude na sredini ekrana ukoliko je moguce
        articleTitle.click();

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("details")));
        WebElement articleHeader = driver.findElement(By.className("details"));
        WebElement title = articleHeader.findElement(By.tagName("h1"));
        Assert.assertTrue("Title of opened article don't match!", title.getText().contains(articleTitleString));


        Thread.sleep(3000);

    }
}
