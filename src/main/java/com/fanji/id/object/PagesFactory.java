package com.fanji.id.object;

import com.fanji.id.object.pages.BasePage;
import global.Const;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.common.ConfigReader;
import utils.common.LogUtil;
import utils.selenium.ElementFinder;

public class PagesFactory {

    private static WebDriver driver;
    private static ConfigReader config;

    private enum Locators {
        ID,
        CLASS_NAME,
        CSS,
        XPATH
    }

    public static void init(WebDriver pDriver) {
        driver = pDriver;
        config = new ConfigReader();
        config.loadFile(Const.PAGES_WAITING);
    }

    private static <TPage extends BasePage> TPage getPage(Class<TPage> pageClass, Locators locator, String value, String page){
        try {

            WebElement element = null;
            switch (locator){
                case ID:
                    element = ElementFinder.findElementById(value);
                    break;
                case CLASS_NAME:
                    element = ElementFinder.findElementByClassName(value);
                    break;
                case CSS:
                    element = ElementFinder.findElementByCss(value);
                    break;
                case XPATH:
                    element = ElementFinder.findElementByXpath(value);
                    break;
                default:
                    try {
                        throw new Exception("Invalid locator");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
            }
            if (element != null){
                LogUtil.info("You are now on page " + page);
                return PagesFactory.initElements(driver, pageClass);
            }
        } catch (Exception ex) {
            String log = String.format("Your are NOT on page %s (element not found with locator %s: %s)", page, locator.toString(), value);
            LogUtil.varn(log);
        }
        return null;
    }
}