package com.automationexercise.browserfactory;

import com.automationexercise.propertyreader.PropertyReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ManageBrowser {

    private static final Logger log= LogManager.getLogger(ManageBrowser.class);
    public static WebDriver driver;
    static String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    static int implicitWait=Integer.parseInt(PropertyReader.getInstance().getProperty("implicitWait"));

    public ManageBrowser() {
        PageFactory.initElements(driver,this);
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/propertiesfile/log4j2.properties");
    }


    public void selectBrowser(String browser) {

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(options);

              log.info("Chrome Browser Launch....");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
              log.info(" Firefox Browser Launch....");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
              log.info("Edge Browser Launch....");
        } else {
              log.info("Wrong browser name.");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(baseUrl);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
