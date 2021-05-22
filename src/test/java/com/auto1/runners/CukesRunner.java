package com.auto1.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                  "html:target/default-report/report.html",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features/Auto1SearchFunction.feature",
        glue = "com/auto1/step_definitions",
        dryRun = false

)
public class CukesRunner {
}
