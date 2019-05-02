package projectApp.tests.noteTests;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@WithTagValuesOf("SmokeTestSuit")
public class ST35_ReportDetailsOpeningTest extends SampleTest {

	@Test
	public void reportDetailsOpeningTest() {
		if(getDriver().getPageSource().contains(" isn't responding")) {
			getDriver().findElement(MobileBy.xpath("//android.widget.Button[@resource-id='android:id/aerr_close']")).click();
		}
		generalPageSteps.loginAsClient("test-android+broker-no-listing-mgmt-core@perchwell.com","perchwell");
		atPerchwellPage.skipAllHints();
		atPerchPopup.clickNotNowButton();
		atPerchwellPage.clickOnAnalytics();
		atRebnyListingsPage.addChartFromREBNYSection();
		atAnalyticsPage.skipHints();
		atRebnyListingsPage.addREBNYListingsAskingPriceChart();
		atAnalyticsPage.upToOneMillionButtonClick();
		atAnalyticsPage.selectSecondBuildingInList();
		atOpenedBuildingPage.clickOnDiscussWithMyClientHint();
		atOpenedBuildingPage.isBuildingOpen();
	}
}
