package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OlxHomePage extends BaseHelper {
    WebDriver driver;

    public OlxHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "notASearchField")
    WebElement searchInputField;
    @FindBy(className = "searchbar-dropdown")
    WebElement searchDropdown;

    private void navigateToPage(String url) {
        driver.get(url);
    }
    private void acceptCookies(){
        List<WebElement> acceptCookiesButton = driver.findElements(By.cssSelector("button[mode='primary']"));// ovo ubacuje nas element u listu ako se pojavio na ekranu
        if (!acceptCookiesButton.isEmpty()) { // <=> acceptCookiesButton.size() != 0
            acceptCookiesButton.get(0).click();
        }
    }


    private void inputSearchTerm(String searchTerm) {
        wdWait.until(ExpectedConditions.visibilityOf(searchInputField));
        searchInputField.sendKeys(searchTerm);
    }

    private void clickSearchButton() {
        wdWait.until(ExpectedConditions.visibilityOf(searchDropdown));
        WebElement searchButton = searchDropdown.findElement(By.tagName("button"));
        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void searchOlx(String url, String searchTerm){
        navigateToPage(url);
        acceptCookies();
        inputSearchTerm(searchTerm);
        clickSearchButton();
    }

}
