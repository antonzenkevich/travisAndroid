package projectApp.tests.noteTests;

import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

@WithTagValuesOf({"TravisTest123", "TravisTest1"})
public class test1 extends SampleTest {

    @Test
    public void logInAsClient() {
        generalPageSteps.loginAsClient("test-android+mgmt-core@perchwell.com","perchwell");
        generalPageSteps.skipAllHints();
        generalPageSteps.clickNotNowButton();
        generalPageSteps.clickOnOpenAccountButton();
        generalPageSteps.shouldSeeOptionAgents();
        generalPageSteps.shouldSeeOptionDiscussions();
        generalPageSteps.shouldSeeOptionTags();
    }
}
