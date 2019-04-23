package projectApp.pages.general;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
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

    @AndroidFindBy(id="com.perchwell.re.staging:id/log_in")
    @iOSXCUITFindBy(accessibility = "LOG IN")
    private WebElement loginButton;

    public boolean plusButtonIsDisplayed() {
        return element(plusButton).isDisplayed();
    }

    public void clickOnPlusButton() {
        element(plusButton).click();
    }

    public void clickOnLoginButton(){
//        System.out.println(getImplicitWaitTimeout());

//
//        setImplicitTimeout(5, TimeUnit.SECONDS);
//        System.out.println(getImplicitWaitTimeout());
//
//        waitABit(5000);
        element(loginButton).click();
//        waitABit(5000);
    }
}
