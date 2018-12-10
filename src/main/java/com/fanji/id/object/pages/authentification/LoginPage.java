package com.fanji.id.object.pages.authentification;

import com.fanji.id.object.pages.BasePage;
import utils.selenium.ElementAction;
import utils.selenium.ElementFinder;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    /*
     * PUBLIC ACTIONS
     */
    public LoginPage typeEmail(String email) {
        ElementAction.typeElementById("email", email, "Email");
        return this;
    }

    public LoginPage typePassword(String password) {
        ElementAction.typeElementById("password", password, "Password");
        return this;
    }

    public LoginPage clickLogInButton() {
        ElementAction.clickElementByXpath("//button[@name='commit']", "Log In button");
        return this;
    }

    /*
     * PUBLIC EXPECTATIONS
     */
    public String seeErrorMessage(String msg) {
        WebElement ele = ElementFinder.findElementByClassName("alert-danger");
        String actualMessage = ele.getText();
        boolean result = actualMessage.equals(msg);
        String log = String.format("  [Expectation] See error message '%s': %b", msg, result);
        if (result) {
            System.out.println(log);
        } else {
            System.out.println(log + String.format(" (actual: '%s')", actualMessage));
        }
        return actualMessage;
    }
}