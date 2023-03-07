package infra.pages.toolsQA.elements;

import infra.pages.toolsQA.ToolsQAHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablesPage extends ToolsQAHomePage {

    public static final By addButton = By.id("addNewRecordButton");

    //Registration form


     public WebTablesPage(WebDriver driver){
         super(driver);
     }


     public ToolsQAHomePage clickAddButton(){
         actionClass.click(addButton);
         return this;
     }


}
