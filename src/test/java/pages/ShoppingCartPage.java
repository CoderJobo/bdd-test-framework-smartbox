package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    By cartDetail = By.xpath(".//div[@id='cart-detail']");

    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean ifNavigatedToShoppingCartPage(){
        return driver.findElement(cartDetail).isDisplayed();
    }

    public boolean isThePopularBoxInShoppingCart(String name) {
        if(driver.findElement(By.xpath(".//img[@title='" + name + "']")).isDisplayed()){
            return true;
        } else {
            return false;
        }
    }
}
