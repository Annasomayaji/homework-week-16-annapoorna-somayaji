package com.automationexercise.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "src/test/resources/features",
            glue = "com/automationexercise/steps",
            tags="@regression"

    )

    public class RunCukeTestRegression extends AbstractTestNGCucumberTests {

    }

