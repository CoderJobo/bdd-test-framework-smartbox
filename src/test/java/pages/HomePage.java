package pages;

import core.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    String popularBoxesPath = ".//h2[contains(text(), 'Our most popular gift boxes' )]/following-sibling::div[@class='thematic-wrapper']/div/div";
    By welcomeMessage = By.xpath(".//h2[contains(text(), 'Who are you shopping for?' )]");
    By popularBoxes = By.xpath(popularBoxesPath);
    WebElement addToCartButton;
    WebElement goToCartButton;
    WebDriverWait wait;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 70);
    }

    public void launchApp(){
        System.out.println("URL:" + TestConfig.getProperty("appBaseURL"));
        driver.get(TestConfig.getAppBaseURL());
        if(driver.findElement(By.xpath(".//button[@id='onetrust-accept-btn-handler']")).isDisplayed()) {
            driver.findElement(By.xpath(".//button[@id='onetrust-accept-btn-handler']")).click();
        }
    }

    public boolean amIOnHomePage(){
        return driver.findElement(welcomeMessage).isDisplayed();
    }

    public WebElement chooseRandomPopularBox() {
        return getRandomBox(driver, popularBoxes);
    }

    public void choosePopularBox(String name) {
        System.out.println("choosePopularBox: " + name);
        int num;
        switch(name.toLowerCase()){
            case "pamper treats" :
                num = 1;
                break;
            case "happy birthday" :
                num = 2;
                break;
            case "adventure escape" :
                num = 3;
                break;
            case "2 night gourmet getaway" :
                num = 4;
                break;
            default :
                num = 1;
                break;
        }
        WebElement popularBox = driver.findElement(By.xpath(popularBoxesPath + "[" + num + "]"));
        popularBox.click();
    }

    public void addPopularBoxToCart(String name) {
        System.out.println("Popular box to add to cart:" + name );
        String addToCartButtonPathBefore = ".//section[@class='row product-summary']//a[@data-boxid='";
        String addToCartButtonPathAfter = "']";
        String boxId;
        switch(name.toLowerCase()) {
            case "pamper treats" :
                boxId = "14271";
                break;
            case "happy birthday" :
                boxId = "14372";
                break;
            case "adventure escape" :
                boxId = "14414";
                break;
            case "2 night gourmet getaway" :
                boxId = "14381";
                break;
            default :
                boxId = "14271";
                break;
        }
        addToCartButton = driver.findElement(By.xpath(addToCartButtonPathBefore + boxId + addToCartButtonPathAfter));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public void goToCart() {
        System.out.println("The amount of iframes is " + driver.findElements(By.tagName("iframe")).size());
        goToCartButton = driver.findElement(By.xpath(".//div[@id='addtocart-confirmation']//a[text()='Go to cart']"));
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
        goToCartButton.click();
    }
}
