package projectApp.tests.noteTests;

import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

@WithTagValuesOf("SmokeTestSuit")
public class ST7_UseExistingTagForListingTest extends SampleTest {

	@Test
	public void useExistingTagForListing() {
		generalPageSteps.loginAsClient("test-android+broker-no-listing-mgmt-core@perchwell.com","perchwell");
		atPerchwellPage.skipAllHints();
		atPerchPopup.clickNotNowButton();
		atPerchwellPage.openFirstBuilding();
		atOpenedBuildingPage.getFirstBuildingAddress();
		atOpenedBuildingPage.clickOnDiscussWithMyClientHint();
		atOpenedBuildingPage.clickOnMyTagsLabel();
		atTagsPage.setRandomTagAndSave();
		atOpenedBuildingPage.clearTagsList();
		atTagsPage.clickOnArrowBackFromTagsButton();
		atOpenedBuildingPage.clickOnMyTagsLabel();
		atTagsPage.clickOnFirstTagAndGetValue();
		atTagsPage.clickOnArrowBackFromTagsButton();
		atOpenedBuildingPage.shouldSeeFirstExistingTag();
		atOpenedBuildingPage.clickOnArrowBackButtonFromListing();
		atPerchwellPage.clickOnOpenAccountButton();
		atAccountPage.clickOnTagsLabel();
		atTagsPage.clickOnExistingTag();
		atTagsPage.clickOnSearchButton();
		atTagsPage.shouldSeeTaggedListing();
	}
}