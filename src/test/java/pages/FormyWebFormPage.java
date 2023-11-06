package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FormyWebFormPage extends BaseHelper {

    WebDriver driver;

    public FormyWebFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstNameInput;
    @FindBy(id = "last-name")
    WebElement lastNameInput;
    @FindBy(id = "job-title")
    WebElement jobTitleInput;
    @FindBy(id = "radio-button-1")
    WebElement radioButton1;
    @FindBy(id = "radio-button-2")
    WebElement radioButton2;
    @FindBy(id = "radio-button-3")
    WebElement radioButton3;
    @FindBy(id = "checkbox-1")
    WebElement checkboxButton1;
    @FindBy(id = "checkbox-2")
    WebElement checkboxButton2;
    @FindBy(id = "checkbox-3")
    WebElement checkboxButton3;
    @FindBy(id = "select-menu")
    WebElement selectYearsExp;
    @FindBy(id = "datepicker")
    WebElement datepickerInputField;
    @FindBy(css = "a[role='button']")
    WebElement submitButton;

    private void inputValue(WebElement inputElement, String value) {
        wdWait.until(ExpectedConditions.visibilityOf(inputElement));
        inputElement.clear();
        inputElement.sendKeys(value);
    }

    private void clickOnElement(WebElement elementToClickOn) {
        wdWait.until(ExpectedConditions.visibilityOf(elementToClickOn));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementToClickOn);
        wdWait.until(ExpectedConditions.elementToBeClickable(elementToClickOn));
        elementToClickOn.click();
    }
    private void navigateToPage(){
        driver.get("https://formy-project.herokuapp.com/form");
    }

    private void selectYearsExp(String yearsOfExp) {
        wdWait.until(ExpectedConditions.visibilityOf(selectYearsExp));
        Select years = new Select(selectYearsExp);
        years.selectByVisibleText(yearsOfExp);
    }

    public void fillOutTheForm(String firstName, String lastName, String jobTitle, String yearsOfExp, String date) {
        navigateToPage();
        inputValue(firstNameInput, firstName);
        inputValue(lastNameInput, lastName);
        inputValue(jobTitleInput, jobTitle);
        clickOnElement(radioButton2);
        clickOnElement(checkboxButton1);
        selectYearsExp(yearsOfExp);
        inputValue(datepickerInputField, date);
        clickOnElement(submitButton);
    }


}
