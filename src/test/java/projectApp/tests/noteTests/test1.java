package projectApp.tests.noteTests;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@WithTagValuesOf({"TravisTest123", "TravisTest1"})
public class test1 extends SampleTest {

    @Test
    public void logInAsClient() {
        if(getDriver().getPageSource().contains("Process system isn't responding")) {
            getDriver().findElement(MobileBy.xpath("//android.widget.Button[resource-id='android:id/aerr_close']")).click();
        }
        generalPageSteps.loginAsClient("test-android+mgmt-core@perchwell.com","perchwell");
        generalPageSteps.skipAllHints();
        generalPageSteps.clickNotNowButton();
        generalPageSteps.clickOnOpenAccountButton();
        generalPageSteps.shouldSeeOptionAgents();
        generalPageSteps.shouldSeeOptionDiscussions();
        generalPageSteps.shouldSeeOptionTags();
    }
}
