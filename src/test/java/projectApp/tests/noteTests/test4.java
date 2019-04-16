package projectApp.tests.noteTests;

import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

@WithTagValuesOf({"TravisTest", "TravisTest1"})
public class test4 extends SampleTest {

    @Test
    public void logInAsClient() {
//        generalPageSteps.loginAsClient();
        generalPageSteps.isPlusButton();
        generalPageSteps.clickOnPlusButton();
    }
}
