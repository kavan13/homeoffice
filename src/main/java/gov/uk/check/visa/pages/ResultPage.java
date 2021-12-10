package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ResultPage extends Utility {
    public ResultPage() {PageFactory.initElements(driver, this);}

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You will not need a visa to come to the UK')]")
    WebElement resultMessage;
      @FindBy(xpath = "//h2[contains(text(),'You need a visa to work in health and care')]")
      WebElement resultText;

    @FindBy(xpath = "//h2[contains(text(),'You’ll need a visa to join your family or partner ')]")
    WebElement resultText1;

    public String getResultMessage(){
        return resultMessage.getText().trim();
    }

    public void confirmResultMessage(String expectedMessage){
        Assert.assertTrue(getResultMessage().equals(expectedMessage), "Message did not match");
    }
    public String getResultMessage2(){
        return resultText.getText().trim();
    }

    public void confirmResultMessage2(String expectedMessage){
        Assert.assertTrue(getResultMessage2().equals(expectedMessage), "Message did not match");
    }
    public String getResultMessage3(){
        return resultText1.getText().trim();
    }

    public void confirmResultMessage3(String expectedMessage){
        Assert.assertTrue(getResultMessage3().equals(expectedMessage), "Message did not match");
    }
}
