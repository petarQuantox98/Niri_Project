package Exercise.Pages;

import LocalUtils.Annotations.WebElementLocator;
import LocalUtils.Annotations.WebElementLocatorFactory;
import NIRI.SiteTools.BaseClass;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SeleniumEasyTable extends BaseClass {
    @WebElementLocator(webDesktop = "//tr[td[4]>='30' and td[4]<=40]")
    private static List<WebElement> tableExample() {
        return getDriver().findElements(By.xpath(new WebElementLocatorFactory().getLocator(SeleniumEasyTable.class, "tableExample")));
    }

    @WebElementLocator(webDesktop = "//a[text()='Next']")
    private static WebElement buttonNext() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(SeleniumEasyTable.class, "buttonNext")));
    }
    public void collectAllData() {
        try {
            List<String> PMPageCMList = tableExample()
                    .stream()
                    .map(user -> user.getAttribute("innerText"))
                    .collect(Collectors.toList());
            PMPageCMList.forEach(System.out::println);
        }

        catch (Exception exception){
            exception.printStackTrace();

        }
    }

    public boolean getDataFromTable()  {
        try {
            for (int i = 0; i < tableExample().size()+3; i++) {
                collectAllData();
                buttonNext().click();
            }
        return true;
        }
        catch (Exception e){
            e.printStackTrace();
       return false;
        }
    }
    public void getDataWithWhileLoop() {
        do {
            collectAllData();
            buttonNext().click();
        }
        while (buttonNext().isDisplayed() && buttonNext().isEnabled());
    }
}
