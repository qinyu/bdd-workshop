package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class StepDefs {
  @Given("^open the home page $")
  public void open_the_home_page() throws Throwable {
    open("http://bdd-qinyu.v2.tenxapp.com:41922");
  }

  @When("^click login $")
  public void click_login() throws Throwable {
    $(By.linkText("Log in")).click();
  }

  @Then("^open the login page successful$")
  public void open_the_login_page_successful() throws Throwable {
    assertThat(url(), containsString("login.php"));
  }


}
