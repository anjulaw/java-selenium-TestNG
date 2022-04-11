package tests;

import infra.pages.PracticePage;
import infra.utils.MainConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentTest extends UITestCase {

    @Test(description = "Assignment Test")
    public void assignmentTest()  {
        driver.get(MainConfig.baseUrl);
        PracticePage practicePage = new PracticePage(driver);
        //This is Step 1
        practicePage.selectRadioButton(2);
        System.out.println("Clicked on radio button");

        //These are step 2 and 3
        practicePage
                .selectCountryFromSuggestList("Sin")
                .selectRandom();

        //This is step 4
        String nameOnAlertExample = "Alert example";
        practicePage
                .enterNameInAlertExample(nameOnAlertExample)
                .clickAlertButton();
        Assert.assertTrue(practicePage.isAlertMessageCorrect(nameOnAlertExample),"Alert message does not contain the input text");

        //This is step 5
        int totalPriceAmount = practicePage.getSumOfPrice();
        System.out.println("Total Price amount is " + totalPriceAmount);
    }
}
