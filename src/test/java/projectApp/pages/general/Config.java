package projectApp.pages.general;

import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Config {

    public static boolean isAndroid () {
//        return getCapability().equals("ANDROID");
        return getCapability("platformName").equals("LINUX");
    }

    private static String getCapability(String Capability) {
        Capabilities capabilities = ((RemoteWebDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).getCapabilities();
        return String.valueOf(capabilities.getCapability(Capability));
    }
}
