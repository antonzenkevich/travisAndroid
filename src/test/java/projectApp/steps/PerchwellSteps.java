package projectApp.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import projectApp.pages.PerchwellPage;
import projectApp.pages.general.Config;

public class PerchwellSteps extends ScenarioSteps {

	PerchwellPage onPage;

	@Step
	public void skipAllHints() {
		if(!Config.isAndroid()) {
			onPage.clickOnEditSearchFiltersHint();
//			if (onPage.isEditSearchFiltersHintIsDisplayed()) {
//				onPage.clickOnEditSearchFiltersHint();
//			}
			onPage.clickOnManageYourProfileHint();
			onPage.clickOnTransformDataHint();
			onPage.clickExploreSearchResultHint();
		}
	}

	@Step
	public void clickOnOpenAccountButton() {
		onPage.clickOnOpenAccountButton();
	}

	@Step
	public void openFirstBuilding() {
		onPage.openFirstBuilding();
	}

	@Step
	public void getFirstListingAddress() {
		onPage.addBuildingAddressInSessionVariable("listingAddress1", onPage.getFistBuildingAddress());
	}

	@Step
	public void clickOnAnalytics() {
		onPage.openAnalytics();
	}

}
