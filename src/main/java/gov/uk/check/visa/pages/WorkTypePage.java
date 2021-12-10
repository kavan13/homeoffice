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

public class WorkTypePage extends Utility {
    public WorkTypePage() {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//div//label")
    List<WebElement> jobTypeRadios;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;

    public void selectJobType(String job){
        for (WebElement work : jobTypeRadios){
            if(work.getText().equals(job)){
                work.click();
                break;
            }
        }
    }

    public void clickNextStepButton(){
        CustomListeners.node.log(Status.PASS, "Click on NextStep button");
        Reporter.log("Click on NextStep button" + "<br>");
        clickOnElement(continueButton);
    }

}
