package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = {
                "src/test/java/features/GetBookByISBN.feature"
        },
        plugin = {
                "usage",
                "json:target/JsonReport/jsonreport.json",
                "html:target/HtmlReport"},
        glue = {"stepdefinitions"},
        dryRun = false,
        monochrome = true
)

public class GetBooksByISBNTestRunner extends AbstractTestNGCucumberTests {
}
