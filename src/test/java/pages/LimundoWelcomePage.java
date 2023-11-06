package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LimundoWelcomePage extends BaseHelper {

    WebDriver driver;

    public LimundoWelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "txtPretraga")
    WebElement searchInputField;
    @FindBy(id = "button-addon2")
    WebElement searchButton;


    private void navigateToPage(String url) {
        driver.get(url);
    }

    private void inputSearchTerm(String searchTerm) {
        wdWait.until(ExpectedConditions.visibilityOf(searchInputField));
        searchInputField.sendKeys(searchTerm);
    }

    private void clickSearchButton() {
        wdWait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }

    public void searchLimundo(String url, String searchTerm) {
        navigateToPage(url);
        inputSearchTerm(searchTerm);
        clickSearchButton();
    }
}
