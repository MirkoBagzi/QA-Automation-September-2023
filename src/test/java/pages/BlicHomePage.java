package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlicHomePage extends BaseHelper {
    WebDriver driver;
    public BlicHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search-input")
    WebElement searchField;
    @FindBy(id = "search")
    WebElement searchComponent;

    private void navigateToPage(String url) {
        driver.get(url);
    }

    private void inputSearchTerm(String searchTerm) {
        wdWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(searchTerm);
    }

    private void clickOnSearchButton() {
        wdWait.until(ExpectedConditions.visibilityOf(searchComponent));
        WebElement searchButton = searchComponent.findElement(By.tagName("button"));
        searchButton.click();
    }

    public void searchBlicTest(String url, String searchTerm) {
        navigateToPage(url);
        inputSearchTerm(searchTerm);
        clickOnSearchButton();
    }
}
