package utils.selenium;

import org.openqa.selenium.WebElement;
import utils.selenium.ElementFinder;

public class ElementAction {
    public static void click(WebElement ele, String... eleName) {
        ele.click();
        if (!eleName[0].isEmpty()) {
            System.out.println(String.format("Click %s", eleName));
        }
    }
    public static void clickElementById(String id, String eleName) {
        WebElement ele = ElementFinder.findElementById(id);
        click(ele, eleName);
    }
    public static void clickElementByClassName(String className, String eleName) {
        WebElement ele = ElementFinder.findElementByClassName(className);
        click(ele, eleName);
    }
    public static void clickElementByXpath(String xpath, String eleName) {
        WebElement ele = ElementFinder.findElementByXpath(xpath);
        click(ele, eleName);
    }
    public static void typeElement(WebElement ele, String value, String... eleName) {
        ele.clear();
        ele.sendKeys(value);
        String log = String.format("Type '%s'", value);
        if (!eleName[0].isEmpty()) {
            log += String.format(" into edit box '%s'", eleName[0]);
        }
        System.out.println(log);
    }
    public static void typeElementById(String id, String value, String... eleName) {
        WebElement element = ElementFinder.findElementById(id);
        typeElement(element, value, eleName);
    }
}