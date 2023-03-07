package infra.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.function.Function;

public class CustomConditions {

    public static Function<WebDriver,Boolean> pageFinishLading(){

        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor)driver;
                return js.executeScript("return document.readyState").equals("complete");
            }
        };
    }
}
