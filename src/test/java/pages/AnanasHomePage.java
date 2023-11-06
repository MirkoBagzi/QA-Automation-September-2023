package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AnanasHomePage extends BaseHelper {
    WebDriver driver;
    public AnanasHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "aa-Input")
    WebElement inputField;
    @FindBy(className = "sc-1fne4lr-1")
    WebElement searchButton;

    private void navigateToHomePage(String url) {
        driver.get(url);
    }

    private void acceptCookies(){
        List<WebElement> cookiesAcceptButton = driver.findElements(By.className("sc-1rhklln-0"));
        if (!cookiesAcceptButton.isEmpty()) {
            wdWait.until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton.get(0)));
            cookiesAcceptButton.get(0).click();
            wdWait.until(ExpectedConditions.invisibilityOf(cookiesAcceptButton.get(0)));
        }
        System.out.println("Accept cookies list size:" + cookiesAcceptButton.size());
    }

    private void insertSearchTerm(String searchTerm) {
        inputField.sendKeys(searchTerm);
    }

    private void clickOnMagnifierButton() {
        searchButton.click();
    }

    public void searchInsertedTerm(String url, String searchTerm) throws InterruptedException {
        navigateToHomePage(url);
        Thread.sleep(1000);
        acceptCookies();
        insertSearchTerm(searchTerm);
        clickOnMagnifierButton();
    }
}
