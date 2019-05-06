package projectApp.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import projectApp.pages.PerchPopupPage;
import projectApp.pages.general.Config;

public class PerchPopupSteps extends ScenarioSteps {

    PerchPopupPage onPage;

    @Step
    public void clickNotNowButton () {
        if(!Config.isAndroid()) {
            onPage.clickOnNotNowButton();
        }
    }
}
