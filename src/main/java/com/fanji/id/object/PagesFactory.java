package com.fanji.id.object;

import org.openqa.selenium.WebDriver;

public class PagesFactory {

    private static WebDriver driver;

    private enum Locators {
        ID,
        CLASS_NAME,
        CSS,
        XPATH
    }

    public static void init(WebDriver pDriver) {
        driver = pDriver;
    }
}