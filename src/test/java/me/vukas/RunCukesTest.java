package me.vukas;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"me.vukas", "cucumber.api.spring"}, features = "src/test/resources/features")
public class RunCukesTest {
}
