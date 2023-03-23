package tests.toolsQATests;

import infra.pages.toolsQA.ToolsQAElementsPage;
import infra.pages.toolsQA.ToolsQAHomePage;
import infra.pages.toolsQA.elements.WebTablesPage;
import infra.utils.MainConfig;
import org.testng.annotations.Test;
import tests.UITestCase;

public class WebTablePractiseTest extends UITestCase {

    @Test(description = "This is to practise Web tables")
    public void webTablesTest() {
        browseToUrl(MainConfig.baseUrl);
        ToolsQAHomePage toolsQAHomePage = new ToolsQAHomePage(driver);
        ToolsQAElementsPage toolsQAElementsPage = toolsQAHomePage.clickElementsCard();

        WebTablesPage webTablesPage = toolsQAElementsPage.clickWebTablesButton();

    }
}
