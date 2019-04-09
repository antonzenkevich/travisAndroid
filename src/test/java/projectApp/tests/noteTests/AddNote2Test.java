package projectApp.tests.noteTests;

import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

@WithTagValuesOf("TravisTest1")
public class AddNote2Test extends SampleTest {

    @Test
    public void secondTest2() {
        generalPageSteps.isPlusButton();
        generalPageSteps.clickOnPlusButton();
    }
}
