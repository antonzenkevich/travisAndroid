package projectApp.tests.noteTests;

import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import projectApp.SampleTest;

@WithTagValuesOf("TravisTest")
public class AddNoteTest extends SampleTest {

    @Test
    public void firstTest1() {
        generalPageSteps.isPlusButton();
        generalPageSteps.clickOnPlusButton();
    }
}
