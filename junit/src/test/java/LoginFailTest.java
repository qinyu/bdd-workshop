import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.BrowserStrategy;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by yqin on 3/12/17.
 */
public class LoginFailTest {

  @BeforeClass
  public static void setUpClass(){
    Configuration.browser= "chrome";
    Configuration.startMaximized = true;
    Configuration.baseUrl = "http://bdd-qinyu.v2.tenxapp.com:41922";
  }

  @Rule
  public BrowserStrategy browserStrategy = new BrowserStrategy();

  static void login_with_wrong_credentials_and_show_error(String user, String pass, String errorMessage) {
    LoginTest.login_with_credentials(user, pass);
    $("#login_error")
        .shouldHave(text(errorMessage));
  }

  @Test
  public void should_show_error_message_if_login_with_wrong_pass() {
    login_with_wrong_credentials_and_show_error("admin", "1234567", "ERROR: The password you entered for the username admin is incorrect. Lost your password?");
  }

  @Before
  public void setUp() {
    LoginTest.gotoLoginPage();
  }

  @Test
  public void should_show_error_message_if_login_with_wrong_user() {
    login_with_wrong_credentials_and_show_error("admin1", "123456", "ERROR: Invalid username. Lost your password?");
  }

  @Test
  public void should_show_error_message_if_login_with_empty_user() {
    login_with_wrong_credentials_and_show_error("", "123456", "ERROR: The username field is empty.");
  }

  @Test
  public void should_show_error_message_if_login_with_empty_pass() {
    login_with_wrong_credentials_and_show_error("admin", "", "ERROR: The password field is empty.");
  }
}
