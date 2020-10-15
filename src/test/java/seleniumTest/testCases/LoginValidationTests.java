package seleniumTest.testCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import seleniumCore.driverManager.DriverManager;
import seleniumCore.driverManager.DriverManagerFactory;
import seleniumCore.driverManager.DriverType;
import seleniumCore.webElementWrapper.Bot;
import seleniumTest.configSetup.UIMap;
import seleniumTest.dataDriven.LoginDataProvider;
import seleniumTest.pageObjectModel.LoginPage;

public class LoginValidationTests {
    WebDriver driver;
    DriverManager driverManager;
    UIMap uiMap;
    LoginPage loginPage;
    Bot bot;
    @BeforeClass
    public void setUp() throws Exception {
        driverManager= DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        String workingDir = System.getProperty("user.dir");
        String configFilePath = workingDir + "\\dataFile.properties";
        uiMap = new UIMap(configFilePath);
        driver.get(uiMap.getData("url"));
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
        loginPage = new LoginPage(driver);
        bot = new Bot (driver);
        driver.manage().window().maximize();
    }
    @Test
    public void loginSuccessTest() throws Exception {
        loginPage.setUserNameInput(uiMap.getData("Username"));
        loginPage.setPasswordInput(uiMap.getData("Password"));
        loginPage.clickLoginButton();
        bot.waitForElementPresent(loginPage.loginSuccessMsg,5);
        String successMsg = loginPage.getLoginSuccessMsg();
        Assert.assertEquals(successMsg, "Welcome Linda");
    }
    @Test(dataProvider = "InvalidLoginData", dataProviderClass = LoginDataProvider.class)
    public void invalidLoginTest(String username, String password){
        loginPage.login(username, password);
        String msg = loginPage.getInvalidLoginMsg();
        Assert.assertEquals(msg, "Invalid credentials");
    }
    @Test (groups = {"test1"})
    public void blankUsernameTest() throws Exception {
        loginPage.setBlankUsername();
        loginPage.setPasswordInput(uiMap.getData("Password"));
        loginPage.clickLoginButton();
        String msg = loginPage.getBlankUsernameMsg();
        Assert.assertEquals(msg,"Username cannot be empty");
    }
    @Test (groups = {"test1"})
    public void blankPasswordTest() throws Exception {
        loginPage.setUserNameInput(uiMap.getData("Username"));
        loginPage.setBlankPassword();
        loginPage.clickLoginButton();
        String msg = loginPage.getBlankPasswordMsg();
        Assert.assertEquals(msg,"Password cannot be empty");
    }
    @AfterClass
    public void tearDown(){
        driverManager.quitWebDriver();
    }
}
