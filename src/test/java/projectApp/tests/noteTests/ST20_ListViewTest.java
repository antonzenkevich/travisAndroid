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
public class ST20_ListViewTest extends SampleTest {

	@Test
	public void listView() {
		WebDriverManager.firefoxdriver().setup();
//		System.setProperty("webdriver.chrome.driver", "/home/travis/.m2/repository/webdriver/chromedriver/linux64/2.46/chromedriver");

		WebDriver chromeDriver = new FirefoxDriver();

		chromeDriver.navigate().to("https://www.google.by/");
		WebElement passwordTextBox = chromeDriver.findElement(By.cssSelector("[class=\"gLFyf gsfi\"]"));
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
//		atPerchPopup.clickNotNowButton();
//		atPerchwellPage.getFirstListingAddress();
//		atPerchwellPage.openFirstBuilding();
//		atOpenedBuildingPage.clickOnDiscussWithMyClientHint();
//		atOpenedBuildingPage.shouldSeeListingAddress();
	}
}
