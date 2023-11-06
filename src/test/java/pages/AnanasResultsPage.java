package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AnanasResultsPage extends BaseHelper {
    WebDriver driver;
    public AnanasResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".sc-1kcrxl6-1.dGwieP")
    WebElement priceContainer;
    @FindBy(css = ".sc-tiv3hw-2.fkmLuS")
    WebElement searchCategory;
    @FindBy(className = "sc-3ghezf-1")
    WebElement resultsNumber;

    private void selectSearchCategory(String searchCategoryName) {
        wdWait.until(ExpectedConditions.visibilityOf(searchCategory));
        List<WebElement> categoryList = searchCategory.findElements(By.tagName("a"));
        for (WebElement category : categoryList) {
            if (category.getText().equalsIgnoreCase(searchCategoryName)) {
                category.click();
                break;
            }
        }
    }

    private void inputMinPrice(String minPrice) {
        WebElement minPriceInput = priceContainer.findElements(By.tagName("input")).get(0);
        minPriceInput.clear();
        while (!minPriceInput.getAttribute("value").isEmpty()) {
            minPriceInput.sendKeys(Keys.BACK_SPACE);
        }
        minPriceInput.sendKeys(minPrice);
    }

    private void inputMaxPrice(String minPrice) {
        WebElement maxPriceInput = priceContainer.findElements(By.tagName("input")).get(1);
        maxPriceInput.clear();
        while (!maxPriceInput.getAttribute("value").isEmpty()) {
            maxPriceInput.sendKeys(Keys.BACK_SPACE);
        }
        maxPriceInput.sendKeys(minPrice);
    }

    private void clickApplyButton() {
        WebElement applyButton = priceContainer.findElement(By.tagName("button"));
        wdWait.until(ExpectedConditions.visibilityOf(resultsNumber));
        String numberOfResultsPriorFilter = resultsNumber.getText();
        applyButton.click();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("sc-3ghezf-1"), numberOfResultsPriorFilter));
    }

    public void selectCategoryInsertPrice(String mainCategory, String category, String minPrice, String maxPrice){
        selectSearchCategory(mainCategory);
        selectSearchCategory(category);
        inputMinPrice(minPrice);
        inputMaxPrice(maxPrice);
        clickApplyButton();
    }

}
