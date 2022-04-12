package com.amazon.cucumber;

import com.amazon.propertyreader.PropertyReader;
import com.amazon.utility.Utility;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;


/**
 * By Dimple Patel
 **/
public class Hooks extends Utility
{
    @Before
    public void setUp()
    {
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
        //Reporter.assignAuthor("Dimple");
    }
    @After //Taking the screenshot
    public void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            String screenShotPath= Utility.getScreenshot(driver,scenario.getName().replace("","_"));
            try {
                Reporter.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        closeBrowser();
    }

}
