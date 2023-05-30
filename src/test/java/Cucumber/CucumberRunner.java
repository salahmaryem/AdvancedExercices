package Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(features = "Features/", glue = "Cucumber", plugin = {"pretty", "html:target/htmlreports.html", "json:target/htmlreports.json"})
    public class CucumberRunner {

    }

