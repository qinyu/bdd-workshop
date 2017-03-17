import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",
    glue = "steps",
    plugin = {"pretty" , "html:target/cucumber", "json:target/cucumber.json"},
    snippets = SnippetType.CAMELCASE,
    tags = {"@smoke", "~@happy"}
)
public class LoginTest {

}
