package projectApp.pages.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import projectApp.pages.general.Config;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TechHelper extends BasePage {

    public TechHelper(WebDriver driver) {
        super(driver);
    }

    //region driver

    public AppiumDriver returnAppiumDriver() {
        WebDriverFacade webDriverFacade = (WebDriverFacade) getDriver();
        WebDriver webDriver = webDriverFacade.getProxiedDriver();

        return (AppiumDriver) webDriver;
    }

    public void swipeUntilButtonShown(WebElement button) {
        setImplicitTimeout(1, SECONDS);
        universalVerticalSwipe(button);
        resetImplicitTimeout();
    }

    //endregion

    //region Swipes

    private void swipeVertical(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * finalPercentage * (-1));

        new TouchAction(driver).longPress(anchor, startPoint).moveTo(10, endPoint).release().perform();
    }

    private void swipeHorizontalWithSetY(AppiumDriver driver, double startPercentage, double finalPercentage, int y, int duration) {

        Dimension size = driver.manage().window().getSize();
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * finalPercentage/* * (-1)*/);

        new TouchAction(driver).longPress(startPoint, y).moveTo(endPoint, y).release().perform();
    }

    private void swipeHorizontalWithSetYAndroid(AppiumDriver driver, double startPercentage, double finalPercentage, int y) {

        Dimension size = driver.manage().window().getSize();
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * finalPercentage);
        new TouchAction(driver).press(startPoint, y).waitAction(Duration.ofSeconds(1)).moveTo(endPoint, y).release().perform();
    }

    private void swipeVerticalAndroid(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * finalPercentage);
        new TouchAction(driver).longPress(anchor, startPoint).moveTo(anchor, endPoint).release().perform();
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void universalVerticalSwipe(WebElement element) {
        int counter = 0;
        WebDriverFacade webDriverFacade = (WebDriverFacade) getDriver();
        WebDriver webDriver = webDriverFacade.getProxiedDriver();
        AppiumDriver appiumDriver = (AppiumDriver) webDriver;

        setImplicitTimeout(1, TimeUnit.SECONDS);
        if(Config.isAndroid()) {
            while (!(isElementDisplayed(element)) && counter < 10) {
                swipeVerticalAndroid(appiumDriver, 0.8, 0.2, 0.5);
                counter += 1;
            }
        } else {
            while (!(isElementDisplayed(element)) && counter < 10) {
                swipeVertical(appiumDriver, 0.8, 0.2, 0.5, 1);
                counter += 1;
            }
        }
        resetImplicitTimeout();
    }

    public void horizontalElementSwipeForIOS(WebElement element, int swipeLength) {
        WebDriverFacade webDriverFacade = (WebDriverFacade) getDriver();
        WebDriver webDriver = webDriverFacade.getProxiedDriver();
        AppiumDriver appiumDriver = (AppiumDriver) webDriver;

//        Dimension size = getDriver().manage().window().getSize();
        int startPoint = (int) (element.getLocation().getX());
        int endPoint = (int) (element.getLocation().getX()-swipeLength);
        int y = (int) (element.getLocation().getY());

        new TouchAction(appiumDriver).longPress(startPoint, y).moveTo(endPoint, y).release().perform();
    }

    public void universalHorizontalSwipe(WebElement element, int y) {
        WebDriverFacade webDriverFacade = (WebDriverFacade) getDriver();
        WebDriver webDriver = webDriverFacade.getProxiedDriver();
        AppiumDriver appiumDriver = (AppiumDriver) webDriver;

        if(Config.isAndroid()) {
            swipeHorizontalWithSetYAndroid(appiumDriver, 0.9, 0.5, y);
        } else {
            swipeHorizontalWithSetY(appiumDriver, 0.9, 0.5, y, 1);
        }
    }

    public void androidSwipeDownUntilElementVisible(String elementName) {
        int counter = 0;
        By byElement = MobileBy.xpath("//*[contains(@text, '" + elementName + "')]");
        boolean isFoundTheElement = getDriver().findElements(byElement).size() > 0;
        WebDriverFacade webDriverFacade = (WebDriverFacade) getDriver();

        WebDriver webDriver = webDriverFacade.getProxiedDriver();
        AppiumDriver appiumDriver = (AppiumDriver) webDriver;
        while (!(isFoundTheElement) && counter < 10) {

            swipeVerticalAndroid(appiumDriver, 0.8, 0.2, 0.5);

            isFoundTheElement = getDriver().findElements(byElement).size() > 0;
            counter += 1;
        }
    }

    public void scrollToElement(WebElement elementForSearch) {
        RemoteWebElement element = (RemoteWebElement) elementForSearch;
        //RemoteWebElement element = (RemoteWebElement)getDriver().findElement(By.name(name));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
        scrollObject.put("toVisible", "not an empty string");
        js.executeScript("mobile:scroll", scrollObject);
    }

    public void swipeUpElementIOS(WebElement element, int duration) {
        WebDriverFacade webDriverFacade = (WebDriverFacade) getDriver();
        WebDriver webDriver = webDriverFacade.getProxiedDriver();
        AppiumDriver appiumDriver = (AppiumDriver) webDriver;

        int x = (int) (element.getLocation().getX());
        int startPoint =  (int) (element.getLocation().getY());
        int endPoint = (int) (element.getLocation().getY()+duration);

        new TouchAction(appiumDriver).longPress(x, startPoint).moveTo(x, endPoint).release().perform();
    }

    //endregion

    //region Coordinates

    public int getYPositionOfElement(WebElement element) {
        int a = element.getLocation().getY();
        return a;
    }


    //endregion
}
