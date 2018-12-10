package strategies;

import com.fanji.id.object.PagesFactory;
import global.Const;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.common.ConfigReader;
import utils.selenium.DriverFactory;
import utils.selenium.ElementFinder;

public class BaseTest {
    private WebDriver driver;
    private ConfigReader configReader = new ConfigReader();
    @Parameters("browser")
    @BeforeTest
    public void initTest(String browserType){
        driver = DriverFactory.getDriverInstance(browserType);
        configReader.loadFile(Const.CONFIG_FILE);
        PagesFactory.init(driver);
        ElementFinder.initDriver(driver);
        String url = configReader.get("site_url");
        driver.get(url);
        System.out.println("======================================");
        System.out.println("Go to Heroku site: " + url);
    }
    @AfterTest
    public void cleanUpTest(){
        driver.quit();
    }
}
