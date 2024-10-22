import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 1; // Current retry count
    private static final int maxRetryCount = 3; // Maximum retry count

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxRetryCount) {
            count++;
            return true; // Retry the test
        }
        return false; // Do not retry
    }
}