import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.BrowserStrategy;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by yqin on 3/12/17.
 */
@RunWith(Parameterized.class)
public class LoginFailTest {

  @Parameters
  public static Collection<Object[]> data() {
   return Arrays.asList(new Object[][]{
       {"admin", "1234567", "ERROR: The password you entered for the username admin is incorrect. Lost your password?"},
       {"admin1", "123456", "ERROR: Invalid username. Lost your password?"},
       {"", "123456", "ERROR: The username field is empty."},
       {"admin", "", "ERROR: The password field is empty."},
   });
  }

  public LoginFailTest(String user, String pass, String errorMessage) {
    this.user = user;
    this.pass = pass;
    this.errorMessage = errorMessage;
  }

  @BeforeClass
  public static void setUpClass(){
    Configuration.browser= "chrome";
    Configuration.startMaximized = true;
    Configuration.baseUrl = "http://bdd-qinyu.v2.tenxapp.com:41922";
  }

  @Rule
  public BrowserStrategy browserStrategy = new BrowserStrategy();


  private String user, pass, errorMessage;

  @Test
  public void should_show_error_message_if_login_with_wrong_credentials() {
    LoginTest.login_with_credentials(this.user, this.pass);
    $("#login_error")
        .shouldHave(text(this.errorMessage));
  }

  @Before
  public void setUp() {
    LoginTest.gotoLoginPage();
  }


}
