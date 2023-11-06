package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YahooHomePage extends BaseHelper {
    WebDriver driver;

    public YahooHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ybar-sbq")
    WebElement searchInputField;
    @FindBy(id = "ybar-search")
    WebElement yahooSearchButton;


    private void navigateToPage(String url) {
        driver.get(url);
    }

    private void inputSearchTerm(String searchTerm) {
        searchInputField.sendKeys(searchTerm);
    }

    private void clickOnSearchButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(yahooSearchButton));
        yahooSearchButton.click();
    }

    public void searchYahoo(String url, String searchTerm) {
        navigateToPage(url);
        inputSearchTerm(searchTerm);
        clickOnSearchButton();
    }

}
