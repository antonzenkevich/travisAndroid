package projectApp.pages.general;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projectApp.pages.base.BasePage;

import java.util.concurrent.TimeUnit;

public class GeneralPage extends BasePage {

    public GeneralPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "ru.andrey.notepad:id/button1")
    private WebElement plusButton;

    @AndroidFindBy(id = "com.perchwell.re.staging:id/log_in")
//    @iOSXCUITFindBy(accessibility = "LOG IN")
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

    @AndroidFindBy(xpath = "//*[@text='AGENTS']")
    @FindBy(how = How.ACCESSIBILITY_ID, using = "AGENTS")
    private WebElement agentsLabel;

    @AndroidFindBy(accessibility = "DISCUSSIONS")
    @FindBy(how = How.ACCESSIBILITY_ID, using = "DISCUSSIONS")
    private WebElement discussionsLabel;

    @AndroidFindBy(accessibility = "TAGS")
    @FindBy(how = How.ACCESSIBILITY_ID, using = "TAGS")
    private WebElement tagsLabel;

    public boolean plusButtonIsDisplayed() {
        return element(plusButton).isDisplayed();
    }

    public void clickOnPlusButton() {
        element(plusButton).click();
    }

    public void clickOnLoginButton() {
//        System.out.println(getImplicitWaitTimeout());

//
//        setImplicitTimeout(5, TimeUnit.SECONDS);
//        System.out.println(getImplicitWaitTimeout());
//
//        waitABit(5000);
        element(loginButton).click();
//        waitABit(5000);
    }

    public void setEmail(String email) {
//      element(emailTextBox).type(email);
        element(emailTextBox).sendKeys(email);
    }

    public void setPassword(String password) {
//        element(passwordField).type(password);
        element(passwordField).sendKeys(password);
    }

    public void clickOnOpenAccountButton() {
        element(openAccountButton).click();
    }

    public void optionAgentsIsDisplayed() {
        element(agentsLabel).shouldBeVisible();
    }

    public void optionDiscussionsIsDisplayed() {
        element(discussionsLabel).shouldBeVisible();
    }

    public void optionTagsIsDisplayed() {
        element(tagsLabel).shouldBeVisible();
    }
}
