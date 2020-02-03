package adminmethods;

import adminpageelements.StatisticsBoxes;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.Waits;

public class StatisticsBoxesMethods {

    private static Driver d = Driver.getInstanceOfDriver();
    private StatisticsBoxes statisticsBoxes;

    public StatisticsBoxesMethods() {

        statisticsBoxes = PageFactory.initElements(d.getDriver(), StatisticsBoxes.class);

    }

    //methods
    //expand all statistics boxes
    public boolean[] expandStatisticsBoxes() {

        boolean[] displayTests = new boolean[statisticsBoxes.dynamicCollapseExpand.size()];
        for (int i=0; i<statisticsBoxes.dynamicCollapseExpand.size(); i++) {
            WebElement element = statisticsBoxes.statisticsBoxContainers.get(i);
            if(!element.isDisplayed()) {
                statisticsBoxes.dynamicCollapseExpand.get(i).click();
                Waits.waitForElementToBeVisible(element);
            }
            //array with true values
            displayTests[i] = element.isDisplayed();
        }
        return displayTests;

    }

    //collapse all statistics boxes
    public boolean[] collapseStatisticsBoxes() {

        boolean[] displayTests = new boolean[statisticsBoxes.statisticsBoxContainers.size()];
        for (int i = 0; i<statisticsBoxes.dynamicCollapseExpand.size(); i++) {
            WebElement element = statisticsBoxes.dynamicCollapseExpand.get(i);
            element.click();
            Waits.waitForElementToBeInvisible(statisticsBoxes.statisticsBoxContainers.get(i));
        }
        for (int i=0; i<statisticsBoxes.dynamicCollapseExpand.size(); i++) {
            WebElement element = statisticsBoxes.statisticsBoxContainers.get(i);
            if(!element.isDisplayed()) {
                displayTests[i] = element.isDisplayed();
            }
        }
        return displayTests;

    }
}
