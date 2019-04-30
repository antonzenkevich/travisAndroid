package projectApp.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import projectApp.pages.AnalyticsPage;

public class AnalyticsSteps extends ScenarioSteps {
	AnalyticsPage onPage;

	@Step
	public void skipHints() {
		onPage.skipHints();
	}

	@Step
	public void upToOneMillionButtonClick() {
		onPage.upToOneMillionButtonClick();
	}

	@Step
	public void selectSecondBuildingInList() {
		onPage.selectSecondBuildingInList();
	}

}
