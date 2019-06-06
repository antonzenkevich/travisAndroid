package projectApp.tests.noteTests;

import io.appium.java_client.MobileBy;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import projectApp.SampleTest;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@WithTagValuesOf("SmokeTestSuit")
public class ST6_CreateNewTagForListingTest extends SampleTest {

	@Test
	public void createNewTagForListing() {
		WebDriverManager.chromedriver().version("2.46").setup();
//		System.setProperty("webdriver.chrome.driver", "/home/travis/.m2/repository/webdriver/chromedriver/linux64/2.46/chromedriver");

		WebDriver chromeDriver = new ChromeDriver();
		System.out.println(1);
		chromeDriver.navigate().to("https://www.google.by/");
		System.out.println(1);
		WebElement passwordTextBox = chromeDriver.findElement(By.cssSelector("[class=\"gLFyf gsfi\"]"));
		System.out.println(1);
		passwordTextBox.sendKeys("Hello world!");
		System.out.println(passwordTextBox.getAttribute("value"));
		chromeDriver.quit();
//		if(getDriver().getPageSource().contains(" isn't responding")) {
//			getDriver().findElement(MobileBy.xpath("//android.widget.Button[@resource-id='android:id/aerr_close']")).click();
//		}
//		System.out.println(getDriver().manage().window().getSize().width);
//		System.out.println(getDriver().manage().window().getSize().height);
//		generalPageSteps.loginAsClient("test-android+mgmt-core@perchwell.com","perchwell");
//		atPerchwellPage.skipAllHints();
//		atPerchwellPage.openFirstBuilding();
//		atOpenedBuildingPage.clickOnDiscussWithMyClientHint();
//		atOpenedBuildingPage.getFirstBuildingAddress();
//		atOpenedBuildingPage.clickOnMyTagsLabel();
//		atOpenedBuildingPage.clearTagsList();
//		atTagsPage.setRandomTagAndSave();
//		atTagsPage.clickOnArrowBackFromTagsButton();
//		atTagsPage.justCreatedTagIsAddedToListing();
//		atOpenedBuildingPage.clickOnArrowBackButtonFromListing();
//		atPerchwellPage.clickOnOpenAccountButton();
//		atAccountPage.clickOnTagsLabel();
//		atTagsPage.shouldSeeJustCreatedTag(); //temp solution for iOS
//		atTagsPage.clickOnCreatedTag();
//		atTagsPage.clickOnSearchButton();
//		atTagsPage.shouldSeeTaggedListing();
	}
}