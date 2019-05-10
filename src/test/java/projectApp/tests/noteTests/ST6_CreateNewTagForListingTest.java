package projectApp.tests.noteTests;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@WithTagValuesOf("SmokeTestSuit")
public class ST6_CreateNewTagForListingTest extends SampleTest {

	@Test
	public void createNewTagForListing() {
		System.out.println(getDriver().getPageSource());
		if(getDriver().getPageSource().contains(" isn't responding")) {
			getDriver().findElement(MobileBy.xpath("//android.widget.Button[@resource-id='android:id/aerr_close']")).click();
		}
		generalPageSteps.loginAsClient("test-android+mgmt-core@perchwell.com","perchwell");
		atPerchwellPage.skipAllHints();
		atPerchPopup.clickNotNowButton();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getDriver().getPageSource());
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