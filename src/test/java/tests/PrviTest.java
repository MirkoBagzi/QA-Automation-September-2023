package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrviTest
{
    @Test
    public void browserTest()
    {

        //1. Open Google Chrome    -->  Google Chrome is opened
        ChromeDriver driver = new ChromeDriver(); // otvaramo Chrome browser

        WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // kreiramo varijablu wdWait koju koristimo da bi sacekali prilikom interakcije sa elementom

        //2. Navigate to https://www.google.com/   --> Google Homepage is shown
        driver.get("https://www.google.com/"); // odlazimo na navedeni URL

        //3. In Search input field insert searched term i.e. "Q Station"  --> Searched term is inserted into search input field
        WebElement inputField; //definisemo varijablu
        inputField = driver.findElement(By.id("APjFqb")); // pronalazimo WebElement na stranici i smjestamo ga u varijablu iznad

        inputField.sendKeys("Q Station"); // upisujemo pojam za pretragu u nase input polje

        //4. Click on "Google Pretrazivanje" button --> Search results are shown with our search term within results
        WebElement searchButton;//definisemo varijablu
        searchButton = driver.findElement(By.name("btnK"));// pronalazimo WebElement na stranici i smjestamo ga u varijablu iznad

        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton)); // cekamo da mozemo da radimo nesto sa nasim WebElementom (maksimalno cekanje je definisano iznad i iznosi 10 sec)

        searchButton.click();// kliknemo na dugme search

        //pronaci element na kome se nalaze rezultati pretrage
        WebElement results;//definisemo varijablu
        results = driver.findElement(By.id("search"));// pronalazimo WebElement na stranici i smjestamo ga u varijablu iznad

        Assert.assertTrue("Search term is not on results page!",results.getText().contains("Q Station")); // provjeravamo da li se na WebElementu, koji smo nasli da sadrzi rezultate, nalazi nas pojam za pretragu
                                                                                                                    //ukoliko se ne nalazi ispisuje se poruka koja je razdvojena zarezom
        driver.quit(); // gasimo nas Chrome browser ukoliko su sve naredbe iznad uspjesno izvrsene
    }
}
