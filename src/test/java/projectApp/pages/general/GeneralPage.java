package projectApp.pages.general;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projectApp.pages.base.BasePage;

public class GeneralPage extends BasePage {

    public GeneralPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "ru.andrey.notepad:id/button1")
    private WebElement plusButton;

    public boolean plusButtonIsDisplayed() {
        return element(plusButton).isDisplayed();
    }

    public void clickOnPlusButton() {
        element(plusButton).click();
    }

}
