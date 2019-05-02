package projectApp.tests.noteTests;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@WithTagValuesOf("SmokeTestSuit")
public class ST7_UseExistingTagForListingTest extends SampleTest {

	@Test
	public void useExistingTagForListing() {
		if(getDriver().getPageSource().contains(" isn't responding")) {
			getDriver().findElement(MobileBy.xpath("//android.widget.Button[@resource-id='android:id/aerr_close']")).click();
		}
		generalPageSteps.loginAsClient("test-android+mgmt-core@perchwell.com","perchwell");
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