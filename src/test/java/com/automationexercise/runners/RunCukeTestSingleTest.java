package com.automationexercise.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/automationexercise/steps",
        tags="@runonlythis",
        plugin = {"rerun:target/failedrun.txt",//stores failed test info in this destination
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber-reports/cucumber.json"

        }


)

public class RunCukeTestSingleTest extends AbstractTestNGCucumberTests {

}
