package com.fanji.id.object.pages.authentification;

import com.fanji.id.object.pages.BasePage;
import global.Const;
import utils.selenium.ElementAction;
import utils.selenium.ElementFinder;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(){
        eleRepo.loadFile(Const.OBJ_LOGIN_PAGE);
    }
    /*
     * PUBLIC ACTIONS
     */
    public LoginPage typeEmail(String email) {
        ElementAction.typeElementById(eleRepo.get("email_input_id"), email, "Email");
        return this;
    }

    public LoginPage typePassword(String password) {
        ElementAction.typeElementById(eleRepo.get("password_input_id"), password, "Password");
        return this;
    }

    public LoginPage clickLogInButton() {
        ElementAction.clickElementByXpath(eleRepo.get("login_button_xpath"), "Log In button");
        return this;
    }

    /*
     * PUBLIC EXPECTATIONS
     */
    public String seeErrorMessage(String msg) {
        WebElement ele = ElementFinder.findElementByClassName(eleRepo.get("error_message_class_name"));
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