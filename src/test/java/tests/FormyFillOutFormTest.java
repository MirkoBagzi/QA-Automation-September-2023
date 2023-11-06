package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.FormyWebFormPage;

public class FormyFillOutFormTest extends BaseTest {

    @Test
    public void fillOutForm() throws InterruptedException {
        String firstName = "Mirko";
        String lastName = "Kitic";
        String jobTitle = "QA Engineer";
        String yearsOfExp = "5-9";
        String date = "10/24/2023";

        FormyWebFormPage formyWebFormPage = new FormyWebFormPage(driver);
        formyWebFormPage.fillOutTheForm(firstName, lastName, jobTitle, yearsOfExp, date);

        WebElement successMessage = wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));
        Assert.assertTrue("Success message not shown properly.",successMessage.getText().contains("The form was successfully submitted!"));

        Thread.sleep(5000);
    }
}
