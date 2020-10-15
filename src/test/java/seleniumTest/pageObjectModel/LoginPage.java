package seleniumTest.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    private By userNameInput = By.xpath(".//input[@id='txtUsername']");
    private By passwordInput = By.xpath(".//input[@id='txtPassword']");
    private By loginButton = By.xpath(".//input[@id='btnLogin']");
    public  By loginSuccessMsg = By.xpath(".//a[@id='welcome'] ");
    private By invalidLoginMsg = By.xpath(".//span[contains(text(),'Invalid credentials')]");
    private By blankPasswordMsg = By.xpath(".//span[contains(text(),'Password cannot be empty')]");
    private By blankUsernameMsg =By.xpath(".//span[contains(text(),'Username cannot be empty')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;

    }
    public void login (String username, String password){
        setUserNameInput(username);
        setPasswordInput(password);
        clickLoginButton();
    }
    public void setUserNameInput(String userName){
        driver.findElement(userNameInput).sendKeys(userName);
    }
    public void setPasswordInput(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public String getLoginSuccessMsg(){
        String msg = driver.findElement(loginSuccessMsg).getText();
        return msg;
    }
    public String getInvalidLoginMsg(){
        String msg = driver.findElement(invalidLoginMsg).getText();
        return msg;
    }
    public void setBlankUsername(){
        driver.findElement(userNameInput).clear();
    }
    public void setBlankPassword(){
        driver.findElement(passwordInput).clear();
    }
    public String getBlankUsernameMsg(){
        String msg = driver.findElement(blankUsernameMsg).getText();
        return msg;
    }
    public String getBlankPasswordMsg(){
        String msg = driver.findElement(blankPasswordMsg).getText();
        return msg;
    }
}
