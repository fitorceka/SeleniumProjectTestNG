package adminpageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class StatisticsBoxes {

    //find elements
    @FindBy(how = How.CSS, using = "div.box-body")
    public List<WebElement> statisticsBoxContainers;

    @FindBy(how = How.CSS, using = "button.btn.btn-box-tool")
    public List<WebElement> dynamicCollapseExpand;

}
