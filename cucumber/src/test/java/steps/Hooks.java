package steps;

import com.codeborne.selenide.Configuration;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

/**
 * Created by yqin on 3/15/17.
 */
public class Hooks {
  @Before
  public void beforeScenario() {
    Configuration.timeout = 6000;
    Configuration.browser = "chrome";
  }

  @After
  public void afterScenario() {
    closeWebDriver();
  }
}
