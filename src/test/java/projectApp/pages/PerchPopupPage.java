package projectApp.pages;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projectApp.pages.base.TechHelper;


public class PerchPopupPage extends TechHelper {

    @iOSXCUITFindBy(accessibility = "NOT NOW")
    private WebElement notNowButton;

    public PerchPopupPage(WebDriver driver){
        super (driver);
    }

    public void clickOnNotNowButton() {
        element(notNowButton).click();
    }
}
