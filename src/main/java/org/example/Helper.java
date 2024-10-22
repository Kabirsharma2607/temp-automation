package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setUp() {
        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
    }

    public static void openWebsite(String URL) {
        driver.get().get(URL);
    }

    public static void enterValues(By xpath, String value) {
        driver.get().findElement(xpath).clear();
        driver.get().findElement(xpath).sendKeys(value);
    }

    public static void clickButton(By xpath) {
        driver.get().findElement(xpath).click();
    }

    public static void closeBrowser() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Clean up driver after use
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (second * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//package org.example;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class Helper {
//    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//
//    private static final String GRID_URL = "http://169.254.101.5:4444/wd/hub";  // Replace with your Grid URL
//    //private static final String GRID_URL = "http://54.221.19.213:4444/wd/hub";  // Replace with your Grid URL
//
//    public static void setUp() {
//        try {
//            // Set Chrome options
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--headless");
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("browserName", "chrome");
//            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//
//            driver.set(new RemoteWebDriver(new URL(GRID_URL), capabilities));
//
//            driver.get().manage().window().maximize();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.err.println("Error setting up WebDriver: " + e.getMessage());
//        }
//    }
//
//    public static void openWebsite(String URL) {
//        driver.get().get(URL);
//    }
//
//    public static void enterValues(By xpath, String value) {
//        driver.get().findElement(xpath).clear();
//        driver.get().findElement(xpath).sendKeys(value);
//    }
//
//    public static void clickButton(By xpath) {
//        driver.get().findElement(xpath).click();
//    }
//
//    public static void closeBrowser() {
//        if (driver.get() != null) {
//            driver.get().quit();
//            driver.remove(); // Clean up driver after use
//        }
//    }
//
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
//
//    public static void sleep(double second) {
//        try {
//            Thread.sleep((long) (second * 1000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
