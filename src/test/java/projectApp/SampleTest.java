package projectApp;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import projectApp.steps.GeneralPageSteps;

@RunWith(SerenityRunner.class)
public abstract class SampleTest {

    @Managed
    WebDriver driver;

    @Steps
    public GeneralPageSteps generalPageSteps;

}
