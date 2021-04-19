package steps;

import core.JSONDataProvider;
import core.TestConfig;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ShoppingCartPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class BaseSteps {

    private static WebDriver driver = null;

    public Map<String, String> data(String dataSet) throws FileNotFoundException {
        File testDataLocation = new File(TestConfig.getTestDataPath());
        String env = TestConfig.getEnv();
        JSONDataProvider dataProvider = new JSONDataProvider(testDataLocation + "/data." + env + ".json");
        return dataProvider.getAllData(dataSet);
    }

    public static void setDriver(WebDriver driver){
        BaseSteps.driver = driver;
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public ShoppingCartPage getShoppingCartPage(){
        return new ShoppingCartPage(driver);
    }
}
