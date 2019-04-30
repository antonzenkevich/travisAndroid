package projectApp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projectApp.pages.base.TechHelper;

public class REBNYListingsPage extends TechHelper {

    @AndroidFindBy(xpath = "//*[@text='PRICE']")
    @iOSXCUITFindBy(accessibility = "PRICE")
    private WebElement askingPriceButton;

    public REBNYListingsPage(WebDriver driver) {
        super(driver);
    }

    public void addREBNYListingsAskingPriceChart() {
        swipeUntilButtonShown(askingPriceButton);
        element(askingPriceButton).click();
    }
}
