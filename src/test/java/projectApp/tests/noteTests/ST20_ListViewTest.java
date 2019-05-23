package projectApp.tests.noteTests;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@WithTagValuesOf({"SmokeTestSuit", "SmokeTestSuit1"})
public class ST20_ListViewTest extends SampleTest {

	@Test
	public void listView() {
		if(getDriver().getPageSource().contains(" isn't responding")) {
			getDriver().findElement(MobileBy.xpath("//android.widget.Button[@resource-id='android:id/aerr_close']")).click();
		}
		System.out.println(getDriver().manage().window().getSize().width);
		System.out.println(getDriver().manage().window().getSize().height);
		generalPageSteps.loginAsClient("test-android+mgmt-core@perchwell.com","perchwell");
		atPerchwellPage.skipAllHints();
		atPerchPopup.clickNotNowButton();
		atPerchwellPage.getFirstListingAddress();
		atPerchwellPage.openFirstBuilding();
		atOpenedBuildingPage.clickOnDiscussWithMyClientHint();
		atOpenedBuildingPage.shouldSeeListingAddress();
	}
}
