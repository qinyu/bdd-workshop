package steps;

import com.codeborne.selenide.Configuration;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by yqin on 3/15/17.
 */
public class Hooks {
  @Before
  public void beforeScenario() {
    Configuration.browser = "chrome";
  }

  @After
  public void afterScenario() {
//    closeWebDriver();
  }
}
