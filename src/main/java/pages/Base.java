package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ConfigReader;
import utils.ExtentReporter;

public class Base 
{
	protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;
    protected ConfigReader config;

    @BeforeSuite
    public void setupExtent() 
    {
        extent = ExtentReporter.getReportInstance();
    }

    @BeforeMethod
    public void setUp() throws IOException 
    {
        config = new ConfigReader();
            String browser = config.getProperty("browser");
//        String url = config.getProperty("url");
        if (browser.equalsIgnoreCase("chrome")) 
		        {
		            driver = new ChromeDriver();
		        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(config.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() 
    {
    driver.quit();
    }

    @AfterSuite
    public void flushReport() 
    {
    if (extent != null)
    {
        extent.flush();
    }
    }
}
