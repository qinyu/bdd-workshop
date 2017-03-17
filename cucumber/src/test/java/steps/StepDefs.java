package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class StepDefs {


  @Then("^open the login page successful$")
  public void open_the_login_page_successful() throws Throwable {
    assertThat(url(), containsString("wp-login.php"));
  }

  @When("^login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void loginWithUsernameAndPassword(String user, String pass) throws Throwable {
//    new classicpages.LoginPage(getWebDriver()).login(user, pass);
//    pageutils.Login.login(user, pass);
    new selenidepages.Login().login(user, pass);
  }

  @Given("^open the home page$")
  public void open_the_home_page() throws Throwable {
    open("http://bdd-qinyu.v2.tenxapp.com:41922");
  }

  @When("^click login$")
  public void click_login() throws Throwable {
    $(By.linkText("Log in")).click();
  }

  @Then("^login successfully$")
  public void loginSuccessfully() throws Throwable {
    assertThat(url(), containsString("wp-admin"));
  }

  @Then("^login failed with message \"([^\"]*)\"$")
  public void loginFailedWithMessage(String errorMessage) throws Throwable {
//    assertThat(new classicpages.LoginPage(getWebDriver()).getErrorMessage().getText(), is(equalTo(errorMessage)));
//    pageutils.Login.errorMessage().shouldHave(text(errorMessage));
    new selenidepages.Login().errorMessage().shouldHave(text(errorMessage));
  }

}
