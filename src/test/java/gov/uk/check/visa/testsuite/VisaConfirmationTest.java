package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends TestBase {
    StartPage startPage;
    SelectNationalityPage selectNationalityPage;
    WorkTypePage workTypePage;
    ResultPage resultPage;
    DurationOfStayPage durationOfStayPage;
    ReasonForTravelPage reasonForTravelPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        startPage = new StartPage();
        selectNationalityPage = new SelectNationalityPage();
        workTypePage = new WorkTypePage();
        resultPage = new ResultPage();
        durationOfStayPage = new DurationOfStayPage();
        reasonForTravelPage = new ReasonForTravelPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();

    }

    //1.anAustralianCominToUKForTourism().
    //    Click on start button
    //	Select a Nationality 'Australia'
    //	Click on Continue button
    //	Select reason 'Tourism'
    //	Click on Continue button
    //	verify result 'You will not need a visa to come to the UK'
    @Test(priority = 1, groups = {"smoke", "regression"})
    public void anAustralianComingToUKForTourism() {
        startPage.clickOnStartNow();
        selectNationalityPage.selectNationality("Australia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForTravel("Tourism");
        reasonForTravelPage.clickNextStepButton();
        resultPage.confirmResultMessage("You will not need a visa to come to the UK");

    }

    @Test(priority = 2, groups = {"sanity", "regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() {

        //Click on start button
        startPage.clickOnStartNow();
        //	Select a Nationality 'Chile'
        selectNationalityPage.selectNationality("Chile");
        //	Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //	Select reason 'Work, academic visit or business'
        reasonForTravelPage.selectReasonForTravel("Work, academic visit or business");

        //	Click on Continue button
        reasonForTravelPage.clickNextStepButton();

        //	Select intendent to stay for 'longer than 6 months'
        durationOfStayPage.selectDurationOfStayBySwitch("longer than 6 months");

        //	Click on Continue button
        durationOfStayPage.clickNextStepButton();
        //	Select have planning to work for 'Health and care professional'
        workTypePage.selectJobType("Health and care professional");
        //	Click on Continue button
        workTypePage.clickNextStepButton();
        //	verify result 'You need a visa to work in health and care'
        resultPage.confirmResultMessage2("You need a visa to work in health and care");

    }
    @Test(priority = 3, groups = {"smoke", "regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){

        startPage.clickOnStartNow();
        selectNationalityPage.selectNationality("Colombia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForTravel("Join partner or family for a long stay");
        reasonForTravelPage.clickNextStepButton();
        familyImmigrationStatusPage.selectImmigrationStatus("Yes");
        familyImmigrationStatusPage.clickNextStepButton();
        resultPage.confirmResultMessage3("You’ll need a visa to join your family or partner in the UK");




    }

}
