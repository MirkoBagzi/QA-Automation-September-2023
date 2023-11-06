package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EPlanetaSearchResultsPage extends BaseHelper {

    public EPlanetaSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "-from")
    WebElement priceFrom;

    @FindBy(className = "-to")
    WebElement priceTo;

    @FindBy(className = "am-filter-go")
    WebElement applyFilterButton;

    @FindBy(id = "toolbar-amount")
    WebElement articleAmount;

    private void inputPriceFrom(String price){
        wdWait.until(ExpectedConditions.visibilityOf(priceFrom));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", priceFrom);
        priceFrom.clear();
        priceFrom.sendKeys(price);
    }

    private void inputPriceTo(String price){
        wdWait.until(ExpectedConditions.visibilityOf(priceTo));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", priceTo);
        priceTo.clear();
        priceTo.sendKeys(price);
    }
    private void clickApplyFilter(){
        wdWait.until(ExpectedConditions.elementToBeClickable(applyFilterButton));
        applyFilterButton.click();
    }

    public void filterPrice(String priceFrom, String priceTo){
        String articleNumber = articleAmount.getText();
        inputPriceFrom(priceFrom);
        inputPriceTo(priceTo);
        clickApplyFilter();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("toolbar-amount"),articleNumber));
    }


}
