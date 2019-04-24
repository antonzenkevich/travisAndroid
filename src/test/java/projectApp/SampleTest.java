package projectApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import projectApp.steps.GeneralPageSteps;

@RunWith(SerenityRunner.class)
public abstract class SampleTest {

    @Managed
    WebDriver driver;

    @Steps
    public GeneralPageSteps generalPageSteps;

    public AppiumDriver returnAppiumDriver() {
        WebDriverFacade webDriverFacade = (WebDriverFacade) driver;
        WebDriver webDriver = webDriverFacade.getProxiedDriver();

        return (AppiumDriver) webDriver;
    }

    @Before
    public void setup() {
        returnAppiumDriver().closeApp();
        System.out.println("close");
        returnAppiumDriver().launchApp();
        System.out.println("run");
    }

}
