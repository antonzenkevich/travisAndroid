package projectApp.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projectApp.pages.base.SessionVariables;
import projectApp.pages.base.TechHelper;
import projectApp.pages.general.Config;
import java.util.concurrent.TimeUnit;

public class OpenedBuildingPage extends TechHelper {

	@iOSXCUITFindBy(accessibility = "DISCUSS THIS WITH YOUR CLIENT OR AGENT. WE'LL ORGANIZE YOUR MESSAGES BY PERSON & LISTING.")
	private WebElement discussThisHint;

	@AndroidFindBy(id = "com.perchwell.re.staging:id/my_tags")
	@iOSXCUITFindBy(accessibility = "TAGS")
	private WebElement myTagsLabel;

	@AndroidFindBy(id = "com.perchwell.re.staging:id/up_button")
	@iOSXCUITFindBy(accessibility = "Back")
	private WebElement arrowBackButtonFromListing;

	@AndroidFindBy(id = "com.perchwell.re.staging:id/title")
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar/XCUIElementTypeStaticText")
	private WebElement buildingAddress;

	@AndroidFindBy(id = "com.perchwell.re.staging:id/title")
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar/XCUIElementTypeStaticText[1]")
	private WebElement buildAddress;

	@AndroidFindBy(xpath = "*//android.widget.ImageView[contains(@content-desc, 'Remove Button: ')]")
	@iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'removeBubble'")
	private WebElement removeButton;

	public OpenedBuildingPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnDiscussWithMyClientHint() {
		if (!Config.isAndroid()) {
			element(discussThisHint).click();
		}
	}

	public void clickOnMyTagsLabel() {
		element(myTagsLabel).click();
	}

	public void clickOnArrowBackButtonFromListing() {
			element(arrowBackButtonFromListing).click();
	}

	public String getBuildingAddress() {
		if (Config.isAndroid()){
			return buildingAddress.getAttribute("text");
		}
		else{
			return buildingAddress.getAttribute("name");
		}
	}

	public void isBuildingOpen() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element(myTagsLabel).shouldBeVisible();
	}

	public void swipeDownUntilElementVisible(WebElement name) {
		universalVerticalSwipe(name);
	}

	public void isBuildingAddressDisplayed() {
		Assert.assertTrue(getBuildingAddress()
				.equalsIgnoreCase(SessionVariables.getValueFromSessionVariable("listingAddress1")));
	}

	public void shouldSeeSpecificTag(String tagName) {
		if(Config.isAndroid()) {
			element(MobileBy.xpath("//*[contains(@text, '" + tagName + "')]")).shouldBeVisible();
		} else {
			element(MobileBy.AccessibilityId(tagName)).shouldBeVisible();
		}
	}

	public void saveFirstBuildingAddress() {
		SessionVariables.addValueInSessionVariable("First_building_address", buildAddress.getAttribute("name"));
	}

    public void clearTagsList() {
		waitABit(3000);
		if(Config.isAndroid()) {
			setImplicitTimeout(3, TimeUnit.SECONDS);
			while (element(MobileBy.xpath("*//android.widget.ImageView[contains(@content-desc, 'Remove Button: ')]")).isVisible()) {
				element(removeButton).click();
			}
			resetImplicitTimeout();
		}
		else {
			setImplicitTimeout(3, TimeUnit.SECONDS);
			while (element(MobileBy.iOSNsPredicateString("label CONTAINS 'removeBubble'")).isVisible()) {
				element(removeButton).click();
			}
			resetImplicitTimeout();
		}
    }

}
