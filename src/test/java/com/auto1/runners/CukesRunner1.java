package com.auto1.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber1.json",
                "html:target/default-report1/report1.html",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/auto1/step_definitions",
        dryRun = false,
        tags = "@smoke"


)
public class CukesRunner1 {
}
