package infra.pages.toolsQA;

import infra.pages.toolsQA.elements.WebTablesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolsQAElementsPage extends ToolsQAHomePage {

    private static final By textBoxLink = By.xpath("//span[contains(text(),'Text Box')]");
    private static final By webTablesLink = By.xpath("//span[contains(text(),'Web Tables')]");

    public ToolsQAElementsPage(WebDriver driver){
        super(driver,textBoxLink);
    }

    public WebTablesPage clickWebTablesButton(){
        actionClass.click(webTablesLink);
        return new WebTablesPage(driver);
    }
}
