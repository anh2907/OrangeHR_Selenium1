package seleniumCore.webElementWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bot {
    private WebDriver driver;
    private WebDriverWait wait;
    public Bot (WebDriver driver){
        this.driver = driver;
    }
    public void waitAndClick(WebElement element, Integer timeout){
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void waitForElementPresent(By element, Integer timeout){
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
