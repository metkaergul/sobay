package com.sobay.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverUtility {
   private static  WebDriver driver;


    private DriverUtility() {
    }



    public static WebDriver getDriver(){

        if(driver==null){
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType){

                case "chrome":
                    //Create a map to store  preferences
                    Map<String, Object> prefs = new HashMap<String, Object>();

//add key and value to map as follow to switch off browser notification
//Pass the argument 1 to allow and 2 to block
                    prefs.put("profile.default_content_setting_values.notifications", 2);

//Create an instance of ChromeOptions
                    ChromeOptions options = new ChromeOptions();

// set ExperimentalOption - prefs
                    options.setExperimentalOption("prefs", prefs);

//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


                    break;


                case "firefox":
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference("permissions.default.desktop-notification", 1);
                    DesiredCapabilities capabilities=DesiredCapabilities.firefox();
                    capabilities.setCapability(FirefoxDriver.PROFILE, profile);

                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(capabilities);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


                    break;

            }


        }


                return driver;

    }

    public static void closeDriver(){

        if(driver!=null){
            driver.quit();
            driver=null;
        }

    }
}
