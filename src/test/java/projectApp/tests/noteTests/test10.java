package projectApp.tests.noteTests;

import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

@WithTagValuesOf({"TravisTest", "TravisTest1"})
public class test10 extends SampleTest {

    @Test
    public void logInAsClient() {
        generalPageSteps.loginAsClient("test-android+mgmt-core@perchwell.com","perchwell");
    }
}
