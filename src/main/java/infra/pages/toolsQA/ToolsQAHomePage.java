package infra.pages.toolsQA;

import infra.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolsQAHomePage extends AbstractPage {

    private static final By elementsCard = By.xpath("(//div[contains(@class,'card mt-4 top-card')])[1]");

    public ToolsQAHomePage(WebDriver webDriver,By...uniqueElements){
        super(webDriver,uniqueElements);
    }

    public ToolsQAHomePage(WebDriver driver){
        super(driver,elementsCard);
    }

    public ToolsQAElementsPage clickElementsCard(){
        actionClass.click(elementsCard);
        return new ToolsQAElementsPage(driver);
    }
}
