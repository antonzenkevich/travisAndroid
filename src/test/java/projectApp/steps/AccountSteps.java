package projectApp.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import projectApp.pages.AccountPage;

public class AccountSteps extends ScenarioSteps {

    AccountPage onPage;

    @Step
    public void clickOnTagsLabel() {
        onPage.clickOnTagsLabel();
    }

    @Step
    public void shouldSeeOptionDiscussions() {
        onPage.optionDiscussionsIsDisplayed();
    }

    @Step
    public void shouldSeeOptionTags() {
        onPage.optionTagsIsDisplayed();
    }

    @Step
    public void shouldSeeOptionAgents() {
        onPage.optionAgentsIsDisplayed();
    }
}
