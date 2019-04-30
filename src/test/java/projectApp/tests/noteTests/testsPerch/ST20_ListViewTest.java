package projectApp.tests.noteTests.testsPerch;

import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

@WithTagValuesOf({"SmokeTestSuit"})
public class ST20_ListViewTest extends SampleTest {

	@Test
	public void listView() {
		generalPageSteps.loginAsClient("test-android+broker-no-listing-mgmt-core@perchwell.com","perchwell");
		atPerchwellPage.skipAllHints();
		atPerchPopup.clickNotNowButton();
		atPerchwellPage.getFirstListingAddress();
		atPerchwellPage.openFirstBuilding();
		atOpenedBuildingPage.clickOnDiscussWithMyClientHint();
		atOpenedBuildingPage.shouldSeeListingAddress();
	}
}
