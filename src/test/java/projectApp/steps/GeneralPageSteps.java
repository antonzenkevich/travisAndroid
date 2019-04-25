package projectApp.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import projectApp.pages.general.GeneralPage;

public class GeneralPageSteps extends ScenarioSteps{

    GeneralPage onPage;

    @Step
    public void isPlusButton() {
        Assert.assertTrue(onPage.plusButtonIsDisplayed());
    }

    @Step
    public void clickOnPlusButton() {
        onPage.clickOnPlusButton();
        waitABit(10000);
    }

    @Step
    public void loginAsClient(String email, String password) {
        onPage.clickOnLoginButton();
        onPage.setEmail(email);
        onPage.setPassword(password);
        onPage.clickOnLoginButton();
    }

    @Step
    public void clickOnOpenAccountButton() {
        onPage.clickOnOpenAccountButton();
    }

    @Step
    public void shouldSeeOptionAgents() {
        onPage.optionAgentsIsDisplayed();
    }

    @Step
    public void shouldSeeOptionDiscussions() {
        onPage.optionDiscussionsIsDisplayed();
    }
    @Step
    public void shouldSeeOptionTags() {
        onPage.optionTagsIsDisplayed();
    }

}
