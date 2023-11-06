package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LimundoSearchResultsPage extends BaseHelper {
    WebDriver driver;

    public LimundoSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "kategorije-pretraga")
    WebElement searchCategory;
    @FindBy(className = "aside-filters")
    WebElement sideFilters;

    private WebElement filterBlock;

    private void selectSearchCategory(String searchCategoryName) {
        wdWait.until(ExpectedConditions.visibilityOf(searchCategory));
        List<WebElement> categoryList = searchCategory.findElements(By.tagName("a"));
        for (WebElement category : categoryList) {
            WebElement categoryTitle = category.findElement(By.tagName("h3"));
            if (categoryTitle.getText().equalsIgnoreCase(searchCategoryName)) {
                category.click();
                break;
            }
        }
    }

    private void expandFilter(String filterName) {
        wdWait.until(ExpectedConditions.visibilityOf(sideFilters));
        List<WebElement> filterList = sideFilters.findElements(By.className("card"));
        for (WebElement filter : filterList) {
            if (filter.getText().toLowerCase().contains(filterName.toLowerCase())) {
                filter.click();
                filterBlock = filter;
                break;
            }
        }
    }

    private void inputFromPrice(String priceFrom, WebElement parentBlock) {
        WebElement priceFromInputField = parentBlock.findElement(By.name("txtCenaOd"));
        priceFromInputField.sendKeys(priceFrom);
    }

    private void inputToPrice(String priceTo, WebElement parentBlock) {
        WebElement priceToInputField = parentBlock.findElement(By.name("txtCenaDo"));
        priceToInputField.sendKeys(priceTo);
    }

    private void applyButton(WebElement parentBlock) {
        WebElement applyButton = parentBlock.findElement(By.id("btnPushPrice"));
        applyButton.click();
    }

    public void selectArticlesWithinPriceRange(String searchCategoryName,String filterName,String from, String to) {
        selectSearchCategory(searchCategoryName);
        expandFilter(filterName);
        inputFromPrice(from, filterBlock);
        inputToPrice(to, filterBlock);
        applyButton(filterBlock);
    }
}
