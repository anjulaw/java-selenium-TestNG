package tests;

import infra.utils.MainConfig;
import infra.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;

public class UITestCase {

    public static  WebDriver driver = null;

    @BeforeSuite(alwaysRun = true)
    public void initSuite(){
        System.out.println("Initiating Main Config properties");
        MainConfig.initMainConfig();
        System.out.println("Main Config property initiated");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws MalformedURLException {
       driver = WebDriverFactory.getWebDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        try{
            if(driver != null){
                driver.close();
            }
        }catch (Exception e){
            System.out.println("Browser already closed");
        }
    }


    public static void browseToUrl(String url){
        driver.navigate().to(url);
    }
}
