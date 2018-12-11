package strategies;

import com.fanji.id.object.PagesFactory;
import global.Const;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.common.ConfigReader;
import utils.common.JsonReader;
import utils.common.LogUtil;
import utils.selenium.DriverFactory;
import utils.selenium.ElementFinder;

public class BaseTest {
    private WebDriver driver;
    private ConfigReader configReader = new ConfigReader();
    protected JsonReader dataReader = new JsonReader(Const.DATA_FILE);
    protected JSONObject testData;
    @Parameters("browser")
    @BeforeTest
    public void initTest(String browserType){
        driver = DriverFactory.getDriverInstance(browserType);
        configReader.loadFile(Const.CONFIG_FILE);
        PagesFactory.init(driver);
        ElementFinder.initDriver(driver);
        String url = configReader.get("site_url");
        driver.get(url);
        LogUtil.info("======================================");
        LogUtil.info("Go to Heroku site: " + url);
    }
    @AfterTest
    public void cleanUpTest(){
        driver.quit();
    }
}
