package com.amazon.cucumber;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

/**
 * Created by Jay Vaghani
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/featurefile", //copy from root path and copy from package
        plugin = {"pretty","html:target/cucumber-report/cucumber.html",
        "com.cucumber.listener.ExtentCucumberFormatter:target/Extent_Reports/report.html",
        "json:target/RunCuke/cucumber.json"},//json is the key and target where we want to run the report
        tags={"@Regression"}
        //Inside plugin we need to inform for default generated reports and then target extent report
)

public class RegressionRunner
{
    @AfterClass
    public static void setUp()
    {
        String projectPath = System.getProperty("user.dir");
        String reportConfigPath = projectPath + "/src/test/java/resources/extentreport/extent-config.xml";
        Reporter.loadXMLConfig(reportConfigPath);
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.141.59");
        Reporter.setSystemInfo("Maven", "3.5.9");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");
    }
}
