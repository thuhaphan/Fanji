package strategies.smoke;


import com.fanji.id.object.pages.authentification.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import strategies.BaseTest;

public class LoginTest extends BaseTest{
    private LoginPage loginPage;

    @BeforeTest
     public void beforeClass(){
        loginPage = new LoginPage();
    }

    @Test (description = "Login failed with an invalid password")
    public void loginFailed(){
        final String ERROR_MSG = "There was a problem with your login!";
        loginPage.typeEmail("public.test@yahoo.com")
                .typePassword("invalid pass")
                .clickLogInButton();
        Assert.assertEquals(loginPage.seeErrorMessage(ERROR_MSG), ERROR_MSG);
    }
}
