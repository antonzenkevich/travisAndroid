package projectApp.tests.noteTests;

import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

@WithTagValuesOf("SmokeTestSuit")
public class ST6_CreateNewTagForListingTest extends SampleTest {

	@Test
	public void createNewTagForListing() {
		generalPageSteps.loginAsClient("test-android+broker-no-listing-mgmt-core@perchwell.com","perchwell");
		atPerchwellPage.skipAllHints();
		atPerchPopup.clickNotNowButton();
		atPerchwellPage.openFirstBuilding();
		atOpenedBuildingPage.clickOnDiscussWithMyClientHint();
		atOpenedBuildingPage.getFirstBuildingAddress();
		atOpenedBuildingPage.clickOnMyTagsLabel();
		atOpenedBuildingPage.clearTagsList();
		atTagsPage.setRandomTagAndSave();
		atTagsPage.clickOnArrowBackFromTagsButton();
		atTagsPage.justCreatedTagIsAddedToListing();
		atOpenedBuildingPage.clickOnArrowBackButtonFromListing();
		atPerchwellPage.clickOnOpenAccountButton();
		atAccountPage.clickOnTagsLabel();
		atTagsPage.shouldSeeJustCreatedTag(); //temp solution for iOS
		atTagsPage.clickOnCreatedTag();
		atTagsPage.clickOnSearchButton();
		atTagsPage.shouldSeeTaggedListing();
	}
}