package seleniumTest.dataDriven;

import org.testng.annotations.DataProvider;
import seleniumTest.configSetup.UIMap;

public class LoginDataProvider {
    String workingDir = System.getProperty("user.dir");
    String configFilePath = workingDir + "\\dataFile.properties";
    UIMap uiMap;
    @DataProvider(name = "InvalidLoginData")
    public Object[][] getLoginData() throws Exception {
        uiMap = new UIMap(configFilePath);
        ReadExcelFile config = new ReadExcelFile(uiMap.getData("testDataPath"));
        int rows = config.getRowCount("InvalidLogin");
        Object[][] data = new Object[rows][2];
        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData("InvalidLogin", i, 0);
            data[i][1] = config.getData("InvalidLogin", i, 1);
        }
        return data;
    }
    @DataProvider(name = "InValidEmail")
    public Object[][] getInvalidEmail() throws Exception {
        uiMap = new UIMap(configFilePath);
        ReadExcelFile config = new ReadExcelFile(uiMap.getData("testDataPath"));
        int rows = config.getRowCount("InValidEmail");
        Object[][] data = new Object[rows][1];
        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData("InValidEmail", i, 0);
        }
        return data;
    }
    @DataProvider(name="InValidPassword")
    public Object[][] getInvalidPassword() throws Exception {
        //Object[][] data = {{"123456"},{"testabc"},{"!@#$%^&*"}};
        uiMap = new UIMap(configFilePath);
        ReadExcelFile config = new ReadExcelFile(uiMap.getData("testDataPath"));
        int rows = config.getRowCount("InValidPassword");
        Object[][] data = new Object[rows][1];
        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData("InValidPassword", i, 0);
        }
        return data;
    }
}
