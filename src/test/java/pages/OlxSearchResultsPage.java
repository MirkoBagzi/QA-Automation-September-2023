package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OlxSearchResultsPage extends BaseHelper {
    WebDriver driver;
    public OlxSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className="filter-box")
    WebElement filters;
    @FindBy(css = "input[placeholder='od']")
    WebElement odInputField;
    @FindBy(xpath = "//input[@placeholder='do']")
    WebElement doInputField;
    @FindBy(className = "search-title")
    WebElement resultsNumber;
    @FindBy(className = "refresh")
    WebElement refreshButton;


    public void openFilter(String filterName){
        wdWait.until(ExpectedConditions.visibilityOf(filters));
        List<WebElement> filterList = filters.findElements(By.className("relative"));
        System.out.println(filterList.size());
        for (WebElement filter : filterList){
            System.out.println(filter.getText());
            wdWait.until(ExpectedConditions.visibilityOf(filter));
            if (filter.getText().trim().equalsIgnoreCase(filterName)){
                filter.click();
                break;
            }
        }
    }

    private void inputFrom(String from) {
        wdWait.until(ExpectedConditions.visibilityOf(odInputField));
        odInputField.click();
        odInputField.sendKeys(from);
    }

    private void inputTo(String to) {
        wdWait.until(ExpectedConditions.visibilityOf(doInputField));
        doInputField.click();
        doInputField.sendKeys(to);
    }

    private void clickRefreshButton() {
        wdWait.until(ExpectedConditions.visibilityOf(refreshButton));
        refreshButton.click();
    }

    public void selectArticlesWithinPriceRange(String from, String to) throws InterruptedException {
        String numberOfSecondResults = resultsNumber.getText();
        openFilter("Cijena");
        inputFrom(from);
        inputTo(to);
        clickRefreshButton();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("search-title"), numberOfSecondResults));
        Thread.sleep(2000);
    }
}
