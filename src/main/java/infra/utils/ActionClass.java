package infra.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ActionClass {

    private final WebDriver driver;
    private WebDriverWait webDriverWait;

    public ActionClass(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(MainConfig.webDriverExplicitWaitInSeconds));
    }

    public void click(By elementLocator){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        System.out.println("Clicking on the element located by " + elementLocator);
        WebElement webElement = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        webElement.click();
    }

    /**
     * Click on a element using WebElement
     * @param webElement
     */
    public void click(WebElement webElement){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        System.out.println("Clicking on the element located by " + webElement );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    public void writeToeElement(By elementLocation,String textToWrite){
        WebElement element = driver.findElement(elementLocation);
        element.clear();
        element.sendKeys(textToWrite);
        System.out.println("Wrote " + textToWrite + " On element" + element);
    }

    public void waitForElementVisibility(By elementLocator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public List<WebElement> getWebElements(By elementLocator){
        return driver.findElements(elementLocator);
    }

    public void selectRandomFromDropDown(By selectElement,By dropDownList){
        List<WebElement> selectListElements = getWebElements(dropDownList);
        int numOfSelectListElements = selectListElements.size();
        if(numOfSelectListElements > 1){
            int randomSelectElementIndex = RandomGenerator.randInt(1, numOfSelectListElements - 1);
            Select selectedElement = new Select(driver.findElement(selectElement));
            selectedElement.selectByIndex(randomSelectElementIndex);
            System.out.println("Selected by the index " + randomSelectElementIndex);
        }
    }

    public void waitForPageLoading(){
        try {
            webDriverWait.until(CustomConditions.pageFinishLading());
        }catch (TimeoutException e){
            System.out.println("Possible slow loading detected");
            WebDriverWait extendedWait = new WebDriverWait(driver, Duration.ofSeconds(MainConfig.webDriverExtendedExplicitWaitInSeconds));
            extendedWait.until(CustomConditions.pageFinishLading());
        }
    }
}
