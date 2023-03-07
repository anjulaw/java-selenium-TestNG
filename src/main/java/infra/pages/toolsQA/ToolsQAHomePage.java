package infra.pages.toolsQA;

import infra.pages.AbstractPage;
import infra.pages.toolsQA.elements.WebTablesPage;
import infra.utils.ActionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolsQAHomePage extends AbstractPage {

    private static final By elementsCard = By.xpath("(//div[contains(@class,'card mt-4 top-card')])[1]");

    public ToolsQAHomePage(WebDriver driver){
        super(driver,elementsCard);
    }

    public WebTablesPage clickElementsCard(){
        actionClass.click(elementsCard);
        return new WebTablesPage(driver);
    }
}
