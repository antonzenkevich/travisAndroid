package projectApp.tests.noteTests;

import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

@WithTagValuesOf("SmokeTestSuit")
public class ST35_ReportDetailsOpeningTest extends SampleTest {

	@Test
	public void reportDetailsOpeningTest() {
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
