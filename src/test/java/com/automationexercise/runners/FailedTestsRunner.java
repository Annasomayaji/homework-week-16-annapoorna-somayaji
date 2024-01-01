package com.automationexercise.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failedrun.txt", //path for failed scenario details
        glue ="com/automationexercise/steps"

)

public class FailedTestsRunner extends AbstractTestNGCucumberTests {
}
