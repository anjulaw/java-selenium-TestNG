package infra.pages;

import infra.utils.ActionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AbstractPage {

    protected WebDriver driver;

    protected ActionClass actionClass;

    protected By[] pageUniqueElements;
    private final String thisPageName;


    public AbstractPage(WebDriver driver, By... pageUniqueElements){
        this(driver,true,pageUniqueElements);
    }

    public AbstractPage(WebDriver driver,boolean verifyOnPage, By... pageUniqueElements){

        this.driver = driver;
        this.actionClass = new ActionClass(driver);
        this.pageUniqueElements = pageUniqueElements;
        this.thisPageName = this.getClass().getSimpleName();

        if(verifyOnPage){
            verifyOnPage();
        }
    }

    public boolean isOnPage(){

        boolean allUniqueElementsFound = true;
        actionClass.waitForPageLoading();

        for(By pageUniqueElement : pageUniqueElements){
            try {
                ExpectedConditions.presenceOfAllElementsLocatedBy(pageUniqueElement);
                System.out.println(pageUniqueElement + " was found");
            }catch (TimeoutException e){
                System.out.println(pageUniqueElement + " was not found");
                allUniqueElementsFound = false;
            }
        }
        System.out.println();
        return allUniqueElementsFound;
    }

    public void verifyOnPage(){
        if(isOnPage()){
            System.out.println(" On page : " + thisPageName + " Current url " + driver.getCurrentUrl());
        }else {
            System.out.println(" Not on the expected page : " + thisPageName + " Current url " + driver.getCurrentUrl());
        }
    }
}
