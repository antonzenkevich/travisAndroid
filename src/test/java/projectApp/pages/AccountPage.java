package projectApp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projectApp.pages.base.TechHelper;

public class AccountPage extends TechHelper {

    @AndroidFindBy(accessibility = "TAGS")
    @iOSXCUITFindBy(accessibility = "TAGS")
    private WebElement tagsLabel;

    @AndroidFindBy(accessibility = "DISCUSSIONS")
    @iOSXCUITFindBy(accessibility = "DISCUSSIONS")
    private WebElement discussionsLabel;

    @AndroidFindBy(xpath = "//*[@text='AGENTS']")
    @iOSXCUITFindBy(accessibility = "AGENTS")
    private WebElement agentsLabel;

    public AccountPage(WebDriver driver){
        super (driver);
    }

    public void clickOnTagsLabel() {
        element(tagsLabel).click();
    }

    public void optionTagsIsDisplayed() {
        element(tagsLabel).shouldBeVisible();
    }

    public void optionDiscussionsIsDisplayed() {
        element(discussionsLabel).shouldBeVisible();
    }

    public void optionAgentsIsDisplayed() {
        element(agentsLabel).shouldBeVisible();
    }
}
