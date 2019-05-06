package projectApp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projectApp.pages.base.TechHelper;
import projectApp.pages.general.Config;

public class AnalyticsPage extends TechHelper {

    @AndroidFindBy(id = "com.perchwell.re.staging:id/rebny_listings")
    @iOSXCUITFindBy(accessibility = "LISTINGS")
    private WebElement rebnyListingsButton;

    @iOSXCUITFindBy(accessibility = "DON'T FORGET... THE SAME SEARCH APPLIES HERE TOO. CHARTS ALWAYS REFLECT YOUR FILTERS")
    private WebElement dontForgetHint;

    @iOSXCUITFindBy(accessibility = "TAP ANY CHART TO ACCESS DETAILED DATA COMPRISING IT")
    private WebElement tapAnyChartHint;

    @iOSXCUITFindBy(accessibility = "PRESS AND HOLD ANY CHART TO REARRANGE OR DELETE")
    private WebElement pressAndHoldHint;

    @AndroidFindBy(xpath = "//*[@text='UP TO $1M']")
    @iOSXCUITFindBy(accessibility = "UP TO $1M")
    private WebElement upToOneMillionButton;

	@AndroidFindBy(xpath = "*//android.widget.RelativeLayout[2]")
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[1]")
	private WebElement secondBuildingTable;


	public AnalyticsPage(WebDriver driver){
        super(driver);
    }

    public void rebnyListingsButtonClick(){
        element(rebnyListingsButton).click();
    }

    public void skipHints() {
	    if(!Config.isAndroid()) {
            element(dontForgetHint).click();
            element(tapAnyChartHint).click();
            element(pressAndHoldHint).click();
        }
    }

    public void upToOneMillionButtonClick(){
            element(upToOneMillionButton).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	public void selectSecondBuildingInList(){
        element(secondBuildingTable).click();
	}
}
