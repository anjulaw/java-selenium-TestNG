package infra.pages;

import infra.utils.ActionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PracticePage {

    WebDriver driver;
    ActionClass actionClass;

    //element locators
    By selectCountryTextBox = By.id("autocomplete");
    By suggestCountryListItems = By.xpath("//ul[@id='ui-id-1']/li");
    By selectDropdown = By.id("dropdown-class-example");
    By selectDropDownItemList = By.xpath("//select/option");
    By alertExampleTextBox = By.id("name");
    By alertButton = By.id("alertbtn");
    By tableExamplePriceElements = By.xpath("(//table[@id='product'])[1]/tbody/tr/td[3]");

    public PracticePage(WebDriver driver){
        this.driver = driver;
        this.actionClass = new ActionClass(driver);
    }

    @SuppressWarnings("UnusedReturnValue")
    public PracticePage selectRadioButton(int radioButtonIndex){
        By radioButton = By.xpath("//div[@id='radio-btn-example']/fieldset/label["+ radioButtonIndex +"]/input");
        actionClass.click(radioButton);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public PracticePage selectCountryFromSuggestList(String textToSearch){
        actionClass.writeToeElement(selectCountryTextBox,textToSearch);
        actionClass.waitForElementVisibility(suggestCountryListItems);
        List<WebElement> suggestCountryList = actionClass.getWebElements(suggestCountryListItems);
        try {
            if(suggestCountryList.size() > 0){
                actionClass.click(suggestCountryList.get(0));
            }
        }catch (Exception e){
            System.out.println("No Suggestions found");
        }
       return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public PracticePage selectRandom(){
        actionClass.selectRandomFromDropDown(selectDropdown,selectDropDownItemList);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public PracticePage enterNameInAlertExample(String name){
        actionClass.writeToeElement(alertExampleTextBox,name);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public PracticePage clickAlertButton(){
        actionClass.click(alertButton);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public boolean isAlertMessageCorrect(String inputText){
       String alertText =  driver.switchTo().alert().getText();
       driver.switchTo().alert().accept();
       return alertText.contains(inputText);
    }

    public int getSumOfPrice(){
        int totalPrice = 0;
        int tempPrice = 0;
        List<WebElement> priceWebElements = actionClass.getWebElements(tableExamplePriceElements);
        for(WebElement priceElement : priceWebElements){
           tempPrice = Integer.parseInt(priceElement.getText().replaceAll("\\D+",""));
            totalPrice = totalPrice + tempPrice;
        }
        return totalPrice;
    }

}
