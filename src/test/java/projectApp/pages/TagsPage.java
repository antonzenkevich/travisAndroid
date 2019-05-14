package projectApp.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projectApp.pages.base.SessionVariables;
import projectApp.pages.base.TechHelper;
import projectApp.pages.general.Config;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TagsPage extends TechHelper {

	@AndroidFindBy(id = "com.perchwell.re.staging:id/search_src_text")
	@iOSXCUITFindBy(accessibility = "Tag Cell: Search Text Field")
	private WebElement searchTagTextBox;

	@AndroidFindBy(xpath = "*//android.widget.TextView[contains(@text, '+ Create tag')]")
	@iOSXCUITFindBy(accessibility = "button: create tag")
	private WebElement createTagLabel;

	@AndroidFindBy(id = "com.perchwell.re.staging:id/up_button")
	@iOSXCUITFindBy(accessibility = "chevronLeft")
	private WebElement arrowBackFromTagsButton;

	@AndroidFindBy(id = "com.perchwell.re.staging:id/search_by_tags")
	@iOSXCUITFindBy(accessibility = "SHOW ITEMS IN SELECTED TAGS")
	private WebElement searchButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView")
	@iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeButton' AND name CONTAINS 'DeleteTagBubbleButton'")
	private WebElement deleteTagButton;

	@AndroidFindBy(xpath = "*//android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[@resource-id='com.perchwell.re.staging:id/tag_name']")
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name CONTAINS '11CLIENTNAME' OR name CONTAINS 'TAGNAME'`][1]")
	private WebElement firstTag;

	@AndroidFindBy(xpath = "//*[contains(@content-desc, 'ADDRESS: ')]")
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$name BEGINSWITH 'ADDRESS: '$][$visible = 1$]")
	private WebElement buildingAddress;

	public TagsPage(WebDriver driver) {
		super(driver);
	}

	public void fillInTagSearchField(String uniqueTagName) {
		waitFor(1000);
		element(searchTagTextBox).sendKeys(uniqueTagName);
	}

	public void clickOnCreateTagLabel() {
		element(createTagLabel).click();
	}

	public void clickOnArrowBackFromTagsButton() {
		element(arrowBackFromTagsButton).click();
	}

	public void clickOnTagLabel(String TagName) {
		this.getCreatedTagLabel(TagName).click();
	}

	public void clickOnSearchButton() {
		element(searchButton).click();
	}

	private WebElement getCreatedTagLabel(String uniqueTagName) {
		WebElement tag;

		if(Config.isAndroid()) {
			tag = getDriver().findElement(MobileBy.xpath("//*[contains(@text, '" + uniqueTagName + " ')]"));
		} else {

			tag = element(MobileBy.iOSNsPredicateString(
					"type == 'XCUIElementTypeStaticText' AND name CONTAINS '" + uniqueTagName + "'"));
		}
		return tag;
	}

	public void shouldSeeJustCreatedTagUpCaseWithSwipe(String tagName) {
		if (Config.isAndroid()) {
			element(searchTagTextBox).sendKeys(tagName);
			element(MobileBy.xpath("//*[contains(@text, '" + tagName + " ')]")).shouldBeVisible();
		} else {
			element(searchTagTextBox).sendKeys(tagName);
			element(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[$name CONTAINS '" + tagName + "'$]")).shouldBeVisible();
//			WebElement justCreatedTag = getDriver().findElement(MobileBy.AccessibilityId(tagName));
//			Helper.swipeDownUntilElementVisible(justCreatedTag);
//			element(justCreatedTag).shouldBeVisible();
		}
	}

	public void justCreatedTagIsAddedToListingWithRemoveAnotherTags(String tagName) {
		if(Config.isAndroid()) {
			while((getDriver().findElements(By.xpath("//*[contains(@text, '" + tagName + "')]")).size() < 1)/* && Helper.isElementDisplayed(moreTagIcon)*/) {
				element(deleteTagButton).click();
			}
			element(MobileBy.xpath("//*[contains(@text, '" + tagName + "')]")).shouldBeVisible();
		} else {
//			while((!(element(MobileBy.AccessibilityId(tagName)).isPresent()))/* && Helper.isElementDisplayed(moreTagIcon)*/) {
//				element(deleteTagButton).click();
//			}
			element(MobileBy.AccessibilityId(tagName)).shouldBeVisible();
		}
	}

	public void shouldSeeTaggedListing(String stringBuildingAddress) {
		if(Config.isAndroid()) {
			Assert.assertEquals(stringBuildingAddress.toLowerCase(), buildingAddress.getAttribute("text").toLowerCase());
		} else {
			Assert.assertEquals(stringBuildingAddress.toLowerCase(), buildingAddress.getAttribute("value").toLowerCase());
		}
	}

    public void clickOnFirstTagAndGetValue() {
        String firstTagAttribute;
        if (Config.isAndroid()) {
            firstTagAttribute = firstTag.getAttribute("text");

            if (firstTagAttribute.contains("Item")) {
                SessionVariables.addValueInSessionVariable("First_Existing_Tag", firstTag.getAttribute("text")
                        .substring(0, firstTag.getAttribute("text").indexOf(" ")));
            } else {
                SessionVariables.addValueInSessionVariable("First_Existing_Tag", firstTagAttribute);
            }
        } else {
            firstTagAttribute = firstTag.getAttribute("value");

            if (firstTagAttribute.contains("item")) {
                SessionVariables.addValueInSessionVariable("First_Existing_Tag", firstTag.getAttribute("value")
                        .substring(0, firstTag.getAttribute("value").indexOf(" ")));
            } else {
                SessionVariables.addValueInSessionVariable("First_Existing_Tag", firstTagAttribute);
            }
        }
        element(firstTag).click();
    }

	public void clickOnExistingTag() {
		if(Config.isAndroid()) {
			element(MobileBy.xpath("//*[contains(@text,'" + SessionVariables.getValueFromSessionVariable("First_Existing_Tag") + "')]")).click();
		} else {
			element(MobileBy.iOSNsPredicateString("value CONTAINS '" + SessionVariables.getValueFromSessionVariable("First_Existing_Tag") + "'")).click();
		}
	}
}