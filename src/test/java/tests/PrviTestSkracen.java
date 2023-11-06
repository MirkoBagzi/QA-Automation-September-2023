package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrviTestSkracen extends BaseTest
{
    @Test
    public void browserTest()
    {
        String searchTerm = "JSGuru";

        //1. Open Google Chrome    -->  Google Chrome is opened
        //2. Navigate to https://www.google.com/   --> Google Homepage is shown
        driver.get("https://www.google.com/"); // odlazimo na navedeni URL

        //3. In Search input field insert searched term i.e. "Q Station"  --> Searched term is inserted into search input field
        WebElement inputField = driver.findElement(By.id("APjFqb")); // pronalazimo WebElement na stranici i smjestamo ga u varijablu iznad

        inputField.sendKeys(searchTerm); // upisujemo pojam za pretragu u nase input polje

        //4. Click on "Google Pretrazivanje" button --> Search results are shown with our search term within results
        WebElement searchButton = driver.findElement(By.name("btnK"));// pronalazimo WebElement na stranici i smjestamo ga u varijablu iznad

        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton)); // cekamo da mozemo da radimo nesto sa nasim WebElementom (maksimalno cekanje je definisano iznad i iznosi 10 sec)

        searchButton.click();// kliknemo na dugme search

        //pronaci element na kome se nalaze rezultati pretrage
        WebElement results = driver.findElement(By.id("search"));// pronalazimo WebElement na stranici i smjestamo ga u varijablu iznad

        Assert.assertTrue("Search term is not on results page!",results.getText().contains(searchTerm)); // provjeravamo da li se na WebElementu, koji smo nasli da sadrzi rezultate, nalazi nas pojam za pretragu
                                                                                                                    //ukoliko se ne nalazi ispisuje se poruka koja je razdvojena zarezom
    }
}
