package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class DurationOfStayPage extends Utility {
    public DurationOfStayPage() {PageFactory.initElements(driver, this);}



    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'6 months or less')]")
    WebElement sixMonthsOrLess;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'longer than 6 months')]")
    WebElement longerThanSixMonths;


    public void selectDurationOfStayBySwitch(String stay) {
        switch (stay.trim()) {
            case "6 months or less":
                clickOnElement(sixMonthsOrLess);
                break;

            case "longer than 6 months":
                clickOnElement(longerThanSixMonths);
                break;
        }
    }


    public void clickNextStepButton() {
        CustomListeners.node.log(Status.PASS, "Click on NextStep button");
        Reporter.log("Click on NextStep button" + "<br>");
        clickOnElement(continueButton);
    }
}
