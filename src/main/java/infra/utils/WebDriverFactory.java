package infra.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public static WebDriver getWebDriver() throws MalformedURLException {

        WebDriver driver = null;

        switch (MainConfig.browserType){

            case CHROME:
                System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;

            case CHROME_REMOTE:
                URL hub = new URL(MainConfig.hubUrl);

                ChromeOptions co = new ChromeOptions();

                co.addArguments("disable-extensions",
                        "disable-gpu", // Disables GPU hardware acceleration
                        "disable-infobars", // Prevent infobars from appearing
                        "disable-web-security", // Don't enforce the same-origin policy
                        "allow-file-access-from-files", // By default, file:// URIs cannot read other file:// URIs. This is an override for developers who need the old behavior for testing
                        "bwsi", // Indicates that the browser is in "browse without sign-in" (Guest session) mode. Should completely disable extensions, sync and bookmarks
                        "enable-automation", // Inform users that their browser is being controlled by an automated test
                        "start-maximized", // Starts the browser maximized, regardless of any previous settings
                        "--no-sandbox", // Disables the sandbox for all process types that are normally sandboxed
                        "--disable-dev-shm-usage", // This will write shared memory files into /tmp instead of /dev/shm
                        "--disable-browser-side-navigation",
                        "--disable-site-isolation-trials");

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.prompt_for_download", false);
                prefs.put("plugins.always_open_pdf_externally", true);
                prefs.put("safebrowsing_for_trusted_sources_enabled", false);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
//                prefs.put("profile.content_settings.exceptions.clipboard", getClipBoardSettingsMap(1));
                prefs.put("useAutomationExtension", false);
                prefs.put("excludeSwitches", "enable-automation");
                co.setExperimentalOption("prefs", prefs);

                // in order to read console from chrome, need to disable w3c due to chrome 75
                // restrictions
                co.setExperimentalOption("w3c", true);

                // selenoid related capabilities
                co.setCapability("enableVNC", true);
                co.setCapability("enableVideo", true);
                co.setCapability("videoFrameRate", 8);
                co.setCapability("enableLog", true); // store selenoid session logs
                co.setCapability("timeZone", "Europe/London");

                RemoteWebDriver remoteDriver;
                try {
                    remoteDriver = new RemoteWebDriver(hub, co);
                } catch (WebDriverException e) {
                    if (e.getMessage().contains("DevToolsActivePort file doesn't exist")) {
                        System.out.println("Retrying init of RemoteWebDriver due to error: " + e.getMessage());
                        remoteDriver = new RemoteWebDriver(hub, co);
                    } else {
                        throw e;
                    }
                }

                remoteDriver.setFileDetector(new LocalFileDetector());
                driver = remoteDriver;
                break;
        }
        return driver;
    }
}
