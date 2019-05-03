package projectApp.pages.general;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projectApp.pages.base.BasePage;

import static java.util.concurrent.TimeUnit.SECONDS;

public class GeneralPage extends BasePage {

    public GeneralPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "ru.andrey.notepad:id/button1")
    private WebElement plusButton;

    @AndroidFindBy(id = "com.perchwell.re.staging:id/log_in")
    @FindBy(how = How.ACCESSIBILITY_ID, using = "LOG IN")
    private WebElement loginButton;

    @AndroidFindBy(id = "com.perchwell.re.staging:id/email")
    @FindBy(how = How.IOS_CLASS_CHAIN, using = "**/XCUIElementTypeTextField")
    private WebElement emailTextBox;

    @AndroidFindBy(id = "com.perchwell.re.staging:id/password")
    @FindBy(how = How.IOS_CLASS_CHAIN, using = "**/XCUIElementTypeSecureTextField")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.perchwell.re.staging:id/background_image")
    @FindBy(how = How.ACCESSIBILITY_ID, using = "Account Bar Button")
    private WebElement openAccountButton;

    @AndroidFindBy(accessibility = "CLIENTS")
    @FindBy(how = How.ACCESSIBILITY_ID, using = "CLIENTS")
    private WebElement clientsLabel;

    @AndroidFindBy(accessibility = "DISCUSSIONS")
    @FindBy(how = How.ACCESSIBILITY_ID, using = "DISCUSSIONS")
    private WebElement discussionsLabel;

    @AndroidFindBy(accessibility = "TAGS")
    @FindBy(how = How.ACCESSIBILITY_ID, using = "TAGS")
    private WebElement tagsLabel;

    @FindBy(how = How.ACCESSIBILITY_ID, using = "EXPLORE SEARCH RESULTS BY LOCATION")
    private WebElement exploreSearchResultHint;

    @FindBy(how = How.ACCESSIBILITY_ID, using = "TRANSFORM DATA INTO MARKET INSIGHTS")
    private WebElement transformDataHint;

    @FindBy(how = How.ACCESSIBILITY_ID, using = "EDIT SEARCH FILTERS OR SEARCH FOR A SPECIFIC ADDRESS")
    private WebElement editSearchFiltersHint;

    @FindBy(how = How.ACCESSIBILITY_ID, using = "MANAGE YOUR PROFILE, CONTACTS, DISCUSSIONS, AND TAGS")
    private WebElement manageYourProfileHint;

    @FindBy(how = How.ACCESSIBILITY_ID, using = "NOT NOW")
    private WebElement notNowButton;

    @AndroidFindBy(id = "android:id/aerr_close")
    private WebElement closeERROR;

    public boolean plusButtonIsDisplayed() {
        return element(plusButton).isDisplayed();
    }

    public void clickOnPlusButton() {
        element(plusButton).click();
    }

    public void clickOnLoginButton() {
        element(loginButton).click();
    }

    public void setEmail(String email) {
        element(emailTextBox).sendKeys(email);
    }

    public void setPassword(String password) {
        element(passwordField).sendKeys(password);
    }

    public void clickOnOpenAccountButton() {
        element(openAccountButton).click();
    }

    public void optionAgentsIsDisplayed() {
        element(clientsLabel).shouldBeVisible();
    }

    public void optionDiscussionsIsDisplayed() {
        element(discussionsLabel).shouldBeVisible();
    }

    public void optionTagsIsDisplayed() {
        element(tagsLabel).shouldBeVisible();
    }

    public void clickOnEditSearchFiltersHint() {
        setImplicitTimeout(1, SECONDS);
        element(editSearchFiltersHint).click();
        resetImplicitTimeout();
    }

    public void clickOnManageYourProfileHint() {
        setImplicitTimeout(1, SECONDS);
        element(manageYourProfileHint).click();
        resetImplicitTimeout();
    }

    public void clickOnTransformDataHint() {
        setImplicitTimeout(1, SECONDS);
        element(transformDataHint).click();
        resetImplicitTimeout();
    }

    public void clickExploreSearchResultHint() {
        setImplicitTimeout(1, SECONDS);
        element(exploreSearchResultHint).click();
        resetImplicitTimeout();
    }

    public void clickOnNotNowButton() {
        element(notNowButton).click();
    }
}
