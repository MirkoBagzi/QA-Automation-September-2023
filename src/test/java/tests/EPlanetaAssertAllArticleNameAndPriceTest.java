package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.EPlanetaHomePage;
import pages.EPlanetaSearchResultsPage;

import java.util.List;

public class EPlanetaAssertAllArticleNameAndPriceTest extends BaseTest {

    @Test
    public void ePlanetaSearchTest() {
        String url = "https://eplaneta.rs/";
        String searchTerm = "usb";
        String priceFrom = "10000";
        String priceTo = "50000";

        EPlanetaHomePage homePage = new EPlanetaHomePage(driver);
        homePage.searchTest(url, searchTerm);

        EPlanetaSearchResultsPage ePlanetaSearchResultsPage = new EPlanetaSearchResultsPage(driver);
        ePlanetaSearchResultsPage.filterPrice(priceFrom, priceTo);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("products")));
        WebElement articles = driver.findElement(By.className("products"));
        List<WebElement> articleList = articles.findElements(By.tagName("li"));

        for (WebElement article : articleList) {
            String title = article.findElement(By.className("product-item-name")).getText();
            softAssertion.assertTrue(title.toUpperCase().contains(searchTerm.toUpperCase()), "Article: \n" + title + "\n does NOT contain Search Term in the tittle!");

            String priceString = article.findElement(By.className("special-price")).getText();//10.555,99 RSD -> String
//            System.out.println("Cijena koju smo pokupili sa elementa: " + priceString);
            String priceFixedString = priceString.replace(" RSD", "").replace(".", "").replace(",", "."); // 10555.99 -> String
//            System.out.println("Cijena kojoj smo uklonili valutu: " + priceFixedString);
            double priceDouble = Double.parseDouble(priceFixedString);// 10555.99 -> Broj tipa double
//            System.out.println("Cijena kao brojna vrijednost tipa double: " + priceDouble);
            // cijenaOd <= cijenaArtikla <= cijenaDo
            softAssertion.assertTrue(Double.parseDouble(priceFrom) <= priceDouble && Double.parseDouble(priceTo) >= priceDouble,
                    "Article: \n" + title + "\nis not within requested range! \nPrice found: " + priceDouble + "\nPrice range is " + Double.parseDouble(priceFrom) + "-" + Double.parseDouble(priceTo));
        }
        softAssertion.assertAll();
    }
}
