package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BlicSearchOpenArticleTest extends BaseTest {
    @Test
    public void searchBlic() throws InterruptedException {
        String searchTerm = "Veselin Jevrosimović";
        int articleNumber = 8;

        //1. Navigate to "https://www.blic.rs/"
        driver.get("https://www.blic.rs/");

        //2. In search input field type search term e.g. "Veselin Jevrosimović"
        WebElement searchInputField = driver.findElement(By.id("search-input"));
        searchInputField.sendKeys(searchTerm);

        //3. Click on magnifier button within search container
        WebElement searchContainer = driver.findElement(By.id("search"));
        WebElement searchButton = searchContainer.findElement(By.tagName("button"));
        searchButton.click();


        //4. Open desired article
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("news-box")));
        WebElement searchResults = driver.findElement(By.className("news-box"));// kontejner za listu (nas <ul> )
        List<WebElement> resultsList = searchResults.findElements(By.tagName("article")); // (article je nas <li> )
//        System.out.println("Broj elemenata u nasoj listi je " + resultsList.size()); // ispisujemo velicinu nase Liste
        //treba nam element liste sa inteksom 7 tj 8. element u listi
        WebElement article = resultsList.get(articleNumber - 1); //biramo artikal ciji je indeks manji od njevog rednog broja za 1
        WebElement articleTitle = article.findElement(By.tagName("h2"));
//        System.out.println(articleTitle.getText());
        String articleTitleString = articleTitle.getText();
        articleTitle.click();

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("article__header")));
        WebElement articleHeader = driver.findElement(By.className("article__header"));
        WebElement title = articleHeader.findElement(By.tagName("h1"));
//        System.out.println(title.getText());
        Assert.assertTrue("Title of opened article don't match!", title.getText().contains(articleTitleString));


        Thread.sleep(3000);

    }
}
