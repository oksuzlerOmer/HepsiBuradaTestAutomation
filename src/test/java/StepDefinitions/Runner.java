package StepDefinitions;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"html","html:target/htmlReports.html"})
public class Runner extends AbstractTestNGCucumberTests {

	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
          return super.scenarios();
    }

}
