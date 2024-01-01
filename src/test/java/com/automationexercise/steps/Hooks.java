package com.automationexercise.steps;

import com.automationexercise.propertyreader.PropertyReader;
import com.automationexercise.utilities.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utility {

    String browser= PropertyReader.getInstance().getProperty("browser");
    @Before
    public void setUp(){
        selectBrowser(browser);
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot=getScreenShot();
            scenario.attach(screenshot,"image/png", scenario.getName());
        }
        closeBrowser();
    }
}
