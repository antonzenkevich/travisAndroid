package projectApp.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import projectApp.pages.OpenedBuildingPage;
import projectApp.pages.base.SessionVariables;
import projectApp.pages.general.Config;

public class OpenedBuildingSteps extends ScenarioSteps {

	OpenedBuildingPage onPage;

	@Step
	public void clickOnDiscussWithMyClientHint() {
		if (!Config.isAndroid()) {
			onPage.clickOnDiscussWithMyClientHint();
		}
	}

	@Step
	public void clickOnMyTagsLabel() {
		onPage.clickOnMyTagsLabel();
	}

	@Step
	public void clickOnArrowBackButtonFromListing() {
		onPage.clickOnArrowBackButtonFromListing();
	}

	@Step
	public void shouldSeeListingAddress() {
		onPage.isBuildingAddressDisplayed();
	}

	@Step
	public void isBuildingOpen() {
		onPage.isBuildingOpen();
	}

	@Step
	public void shouldSeeFirstExistingTag() {
		onPage.shouldSeeSpecificTag(SessionVariables.getValueFromSessionVariable("First_Existing_Tag"));
	}

	@Step
	public void getFirstBuildingAddress() {
		onPage.saveFirstBuildingAddress();
	}

    @Step
    public void clearTagsList() {
		onPage.clearTagsList();
    }
}

