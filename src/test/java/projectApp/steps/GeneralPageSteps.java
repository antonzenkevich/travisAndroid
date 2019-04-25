package projectApp.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import projectApp.pages.general.GeneralPage;

public class GeneralPageSteps extends ScenarioSteps{

    GeneralPage atPage;

    @Step
    public void isPlusButton() {
        Assert.assertTrue(atPage.plusButtonIsDisplayed());
    }

    @Step
    public void clickOnPlusButton() {
        atPage.clickOnPlusButton();
        waitABit(10000);
    }

    @Step
    public void loginAsClient(String email, String password) {
        atPage.clickOnLoginButton();
//        atPage.setEmail(email);
//        atPage.setPassword(password);
//        atPage.clickOnLoginButton();
    }
}
