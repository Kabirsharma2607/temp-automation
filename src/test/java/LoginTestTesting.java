import com.github.javafaker.Faker;
import org.example.Helper;
import org.example.ScreenshotHelper;
import org.example.utils.*;
import org.mortbay.log.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;

@Test()
public class LoginTestTesting {

    //WebDriver driver;

    private static Faker faker = new Faker();

    LoginTest loginTest = new LoginTest();
    //ExcelUtil excelUtil = new dataList("src/test/datafiles/test_credentials.xlsx", "Sheet1");

    List<Data> dataList = JsonUtil.getLoginDataList();

    @BeforeMethod
    public void setUp() {
        // Set up browser instance for each test
        Helper.setUp();
    }

    public LoginTestTesting() throws IOException {
    }

    @Test(priority = 1)
    public void TC_loginWithEmailNull() {
        try {
            LogUtil.logInfo("Executing TC_loginWithEmailNull...");
            String URL = loginTest.loginWithEmailNull();
            boolean isSuccess = !URL.contains("workteam");
            Assert.assertTrue(isSuccess, "Login was not successful: " + URL);

            if (isSuccess) {
                LogUtil.logInfo("TC_loginWithEmailNull - Test Passed. URL: " + URL);
            } else {
                LogUtil.logError("TC_loginWithEmailNull - Test Failed. URL: " + URL);
            }
        } catch (Exception e) {
            LogUtil.logError("TC_loginWithEmailNull - Test Failed with Exception: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void TC_loginWithPasswordNull() {
        try {
            LogUtil.logInfo("Executing TC_loginWithPasswordNull...");
            //String URL = loginTest.loginWithPasswordNull(excelUtil.getCellValueByColumnName(1, "Email"), excelUtil.getCellValueByColumnName(1, "Password"));
            //Data data = dataList.get(1);
            //String email = data.getEmail();
            //String password = data.getPassword();

            String email = faker.internet().emailAddress();
            String password = faker.internet().password(8, 16, true, true, true);
            System.out.println(email + " " + password);
            String URL = loginTest.loginWithPasswordNull(email, password);
            boolean isSuccess = !URL.contains("workteam");
            Assert.assertTrue(isSuccess, "Login was not successful: " + URL);

            if (isSuccess) {
                LogUtil.logInfo("TC_loginWithPasswordNull - Test Passed. URL: " + URL);
            } else {
                LogUtil.logError("TC_loginWithPasswordNull - Test Failed. URL: " + URL);
            }
        } catch (Exception e) {
            LogUtil.logError("TC_loginWithPasswordNull - Test Failed with Exception: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void TC_loginWithBothWrong() {
        try {
            LogUtil.logInfo("Executing TC_loginWithBothWrong...");
            //String URL = loginTest.loginWithBothWrong(excelUtil.getCellValueByColumnName(2, "Email"), excelUtil.getCellValueByColumnName(2, "Password"));
//            Data data = dataList.get(2);
//            String email = data.getEmail();
//            String password = data.getPassword();
            String email = faker.internet().emailAddress();
            String password = faker.internet().password(8, 16, true, true, true);
            System.out.println(email + " " + password);
            String URL = loginTest.loginWithBothWrong(email, password);
            boolean isSuccess = !URL.contains("workteam");
            Assert.assertTrue(isSuccess, "Login was not successful: " + URL);

            if (isSuccess) {
                LogUtil.logInfo("TC_loginWithBothWrong - Test Passed. URL: " + URL);
            } else {
                LogUtil.logError("TC_loginWithBothWrong - Test Failed. URL: " + URL);
            }
        } catch (Exception e) {
            LogUtil.logError("TC_loginWithBothWrong - Test Failed with Exception: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void TC_loginWithWrongPassword() {
        try {
            LogUtil.logInfo("Executing TC_loginWithWrongPassword...");
            //String URL = loginTest.loginWithWrongPassword(excelUtil.getCellValueByColumnName(3, "Email"), excelUtil.getCellValueByColumnName(3, "Password"));
//            Data data = dataList.get(3);
//            String email = data.getEmail();
//            String password = data.getPassword();
            String email = faker.internet().emailAddress();
            String password = faker.internet().password(8, 16, true, true, true);
            System.out.println(email + " " + password);
            String URL = loginTest.loginWithWrongPassword(email,password);
            boolean isSuccess = !URL.contains("workteam");
            Assert.assertTrue(isSuccess, "Login was not successful: " + URL);

            if (isSuccess) {
                LogUtil.logInfo("TC_loginWithWrongPassword - Test Passed. URL: " + URL);
            } else {
                LogUtil.logError("TC_loginWithWrongPassword - Test Failed. URL: " + URL);
            }
        } catch (Exception e) {
            LogUtil.logError("TC_loginWithWrongPassword - Test Failed with Exception: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void TC_successfulLogin() {
        try {
            LogUtil.logInfo("Executing TC_successfulLogin...");
            //String email = excelUtil.getData(3);
            //String password = excelUtil.getData(4, "Password");
            Data data = dataList.get(4);
            String email = data.getEmail();
            String password = data.getPassword();
            String URL = loginTest.successfulLogin(email, password);

            boolean isSuccess = URL.contains("srai");

            if (isSuccess) {
                LogUtil.logInfo("TC_successfulLogin - Test Passed. URL: " + URL);
            } else {
                LogUtil.logError("TC_successfulLogin - Test Failed. URL does not contain 'srai'. URL: " + URL);
            }

            Assert.assertTrue(isSuccess, "Login was successful: " + URL);

        } catch (Exception e) {
            LogUtil.logError("TC_successfulLogin - Test Failed with Exception: " + e.getMessage());
            throw e;
        }
    }


    @AfterMethod
    public void tearDown() {
        // Capture screenshot after each test
        //String testName = new Throwable().getStackTrace()[1].getMethodName();
        //ScreenshotHelper.takeScreenshot(Helper.getDriver(), testName);
        LogUtil.logInfo("Test execution completed, closing browser.");
        Helper.closeBrowser();
    }

    @AfterClass
    public void cleanUp() {
        LogUtil.logInfo("All tests completed.");
    }


//    @AfterSuite
//    public void sendEmailReport() {
//        LogUtil.logInfo("Sending Email...");
//        String reportFilePath = System.getProperty("user.dir") + "/test-output/emailable-report.html";
//        String toEmail = "kabirsharma2607@gmail.com";
//        String subject = "TestNG Report - Test Execution Summary";
//        String body = "Please find the attached test execution report.";
//        LogUtil.logInfo("Email has been sent successfully to: " + toEmail);
//        LogUtil.close();
//        EmailUtil.sendTestReport(toEmail, subject, body, reportFilePath);
//    }
}
