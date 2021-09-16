package NIRI.Pages;

import LocalUtils.Annotations.WebElementLocator;
import LocalUtils.Annotations.WebElementLocatorFactory;
import NIRI.SiteTools.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class BlogPage extends BaseClass {

    // Web elements
    @WebElementLocator(webDesktop = "//article[@class='blog-post-item']/header")
    private static List<WebElement> textFromElementsHeader() {
        return getDriver().findElements(By.xpath(new WebElementLocatorFactory().getLocator(BlogPage.class, "textFromElementsHeader")));
    }

    @WebElementLocator(webDesktop = "//div[@class='pagination']/*")
    private static List<WebElement> allElementsFromPagination() {
    return getDriver().findElements(By.xpath(new WebElementLocatorFactory().getLocator(BlogPage.class, "allElementsFromPagination")));
    }
    @WebElementLocator(webDesktop = "//div[@class='pagination']/a[2]")
    private static WebElement buttonNextOnPagination() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(BlogPage.class, "buttonNextOnPagination")));
    }
    // Actions
    public int allPostFromBlogPage() {
        List<WebElement> tools = textFromElementsHeader();
        final  int size = tools.size();
        return size;
    }
    public boolean clickOnPaginationAsLongAsButtonNextExist(){
        List<WebElement>list= allElementsFromPagination();
        List<String> names = new ArrayList<String>();
        for (WebElement nameEle : list){
            names.add(nameEle.getText());
            System.out.println(names);
        }
        if(list .size()>0){
            for(int i=0; i<list .size(); i++){
                list.get(i).click();
            }
            return true;
        }
        else {
        return false;
        }
    }
    public boolean txtHeaderFromPage1()  {
        List<WebElement> elements=textFromElementsHeader();
        try {
            List<String> txt = new ArrayList<>();
            for (WebElement nameEle : elements) {
                txt.add(nameEle.getText());
            }
            return true;
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex){
            System.out.println(ex);
            return false;
        }
    }

    public boolean txtHeaderFromPage2() {
        buttonNextOnPagination().click();
        scrollToElement(buttonNextOnPagination());
        List<WebElement> headerText = textFromElementsHeader();

        try {
            List<String> text = new ArrayList<>();
            for (WebElement nameEle : headerText) {
                text.add(nameEle.getText());
            }
            return true;
        }
         catch (org.openqa.selenium.StaleElementReferenceException ex){
                System.out.println(ex);
             return false;
         }
        }
    }