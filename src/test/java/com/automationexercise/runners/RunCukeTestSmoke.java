package com.automationexercise.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/automationexercise/steps",
        tags = "@smoke"

)

public class RunCukeTestSmoke extends AbstractTestNGCucumberTests {


}
