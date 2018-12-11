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
        // Test data
        testData = dataReader.get("tc01");
        final String USERNAME = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");
        final String ERROR_MSG = (String) testData.get("errorMessage");

        // Test case
        loginPage.typeEmail(USERNAME)
                .typePassword(PASSWORD)
                .clickLogInButton();
        Assert.assertEquals(loginPage.seeErrorMessage(ERROR_MSG), ERROR_MSG);
    }
}
