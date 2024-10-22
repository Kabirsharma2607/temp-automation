import io.qameta.allure.Allure;
import org.example.ScreenshotHelper;
import org.example.reports.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //captureScreenshot(result);
        ExtentReportManager.getInstance().createTest(result.getMethod().getMethodName()).pass("Test Passed");
        Allure.addAttachment("Test Passed", "Test case " + result.getMethod().getMethodName() + " passed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //captureScreenshot(result);
        ExtentReportManager.getInstance().createTest(result.getMethod().getMethodName()).fail("Test Failed");
        Allure.addAttachment("Test Failed", "Test case " + result.getMethod().getMethodName() + " failed.");
    }

//    private void captureScreenshot(ITestResult result) {
//        Object currentClass = result.getInstance();
//        WebDriver driver = ((LoginTestTesting) currentClass).getDriver();
//        ScreenshotHelper.takeScreenshot(driver, result.getName());
//    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flush();
    }
}
