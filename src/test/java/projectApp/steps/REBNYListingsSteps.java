package projectApp.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import projectApp.pages.AnalyticsPage;
import projectApp.pages.REBNYListingsPage;

public class REBNYListingsSteps extends ScenarioSteps {
    REBNYListingsPage rebnyListingsPage;
    AnalyticsPage analyticsPage;

    @Step
    public void addREBNYListingsAskingPriceChart() {
        rebnyListingsPage.addREBNYListingsAskingPriceChart();
    }

    @Step
    public void addChartFromREBNYSection() {
        analyticsPage.rebnyListingsButtonClick();
        rebnyListingsPage.addREBNYListingsAskingPriceChart();
    }
}
