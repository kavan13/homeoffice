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

public class FamilyImmigrationStatusPage extends Utility {
    public FamilyImmigrationStatusPage() {
        PageFactory.initElements(driver, this);
    }





    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Yes')]")
    WebElement yesRadiobtn;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'No')]")
    WebElement noRadiobtn;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;


    public void selectImmigrationStatus(String status) {
        switch (status.trim()) {
            case "Yes":
                clickOnElement(yesRadiobtn);
                break;
            case "No":
                clickOnElement(noRadiobtn);
                break;
        }
    }



    public void clickNextStepButton() {
        CustomListeners.node.log(Status.PASS, "Click on NextStep button");
        Reporter.log("Click on NextStep button" + "<br>");
        clickOnElement(continueButton);
    }
}
