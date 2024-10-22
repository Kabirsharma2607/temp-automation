import org.example.ConfigReader;
import org.example.Helper;
import org.example.ScreenshotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    String URL = ConfigReader.getString("WEBSITE_URL");
    By emailInput = By.xpath("//input[@id='username']");
    By passwordInput = By.xpath("//input[@id='userpassword']");
    By buttonLogin = By.xpath("//button[@type='button']");

    public String loginWithEmailNull() {
        WebDriver driver = Helper.getDriver();
        Helper.openWebsite(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Helper.clickButton(buttonLogin);
        Helper.sleep(3);
        String testName = new Throwable().getStackTrace()[1].getMethodName();
        ScreenshotHelper.takeScreenshot(Helper.getDriver(), testName);
        String currentUrl = driver.getCurrentUrl();
        Helper.closeBrowser();
        return currentUrl;
    }


    public String loginWithPasswordNull(String email, String password) {
        WebDriver driver = Helper.getDriver();
        Helper.openWebsite(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        Helper.enterValues(emailInput, email);
        Helper.enterValues(passwordInput, password);
        Helper.clickButton(buttonLogin);
        Helper.sleep(3);
        String testName = new Throwable().getStackTrace()[1].getMethodName();
        ScreenshotHelper.takeScreenshot(Helper.getDriver(), testName);
        String currentUrl = driver.getCurrentUrl();
        Helper.closeBrowser();
        return currentUrl;
    }

    public String loginWithBothWrong(String email, String password) {
        WebDriver driver = Helper.getDriver();
        Helper.openWebsite(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        Helper.enterValues(emailInput, email);
        Helper.enterValues(passwordInput, password);
        Helper.clickButton(buttonLogin);
        Helper.sleep(3);
        String testName = new Throwable().getStackTrace()[1].getMethodName();
        ScreenshotHelper.takeScreenshot(Helper.getDriver(), testName);
        String currentUrl = driver.getCurrentUrl();
        Helper.closeBrowser();
        return currentUrl;
    }

    public String loginWithWrongPassword(String email, String password) {
        WebDriver driver = Helper.getDriver();
        Helper.openWebsite(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        Helper.enterValues(emailInput, email);
        Helper.enterValues(passwordInput, password);
        Helper.clickButton(buttonLogin);
        Helper.sleep(3);
        String testName = new Throwable().getStackTrace()[1].getMethodName();
        ScreenshotHelper.takeScreenshot(Helper.getDriver(), testName);
        String currentUrl = driver.getCurrentUrl();
        Helper.closeBrowser();
        return currentUrl;
    }

    public String successfulLogin(String email, String password) {
        WebDriver driver = Helper.getDriver();
        Helper.openWebsite(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        Helper.enterValues(emailInput, email);
        Helper.enterValues(passwordInput, password);
        Helper.clickButton(buttonLogin);
        Helper.sleep(3);
        String testName = new Throwable().getStackTrace()[1].getMethodName();
        ScreenshotHelper.takeScreenshot(Helper.getDriver(), testName);
        Helper.sleep(7);
        String currentUrl = driver.getCurrentUrl();
        Helper.closeBrowser();
        return currentUrl;
    }
}
