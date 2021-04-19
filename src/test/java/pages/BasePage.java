package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class BasePage {

    Random rand = new Random();

    public void moveToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public List<WebElement> getBoxes(WebDriver driver, By boxList){
        return driver.findElements(boxList);
    }

    public WebElement getRandomBox(WebDriver driver, By boxList){
        List<WebElement> boxes = getBoxes(driver, boxList);
        System.out.println("Size of list 'boxes': " + boxes.size());
        for(WebElement box : boxes){
            System.out.println("Box: " + box.getText());
        }
        WebElement box = boxes.get(rand.nextInt(boxes.size())) ;
        System.out.println("Random box: " + box.getText());
        return box;
    }


}
