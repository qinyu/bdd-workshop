import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.BrowserStrategy;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.By.linkText;

/**
 * Created by yqin on 3/12/17.
 */
public class LoginTest {

  @Rule
  public BrowserStrategy browserStrategy = new BrowserStrategy();


  @BeforeClass
  public static void setUp() {
    Configuration.browser = "chrome";
    Configuration.startMaximized = true;
    Configuration.baseUrl = "http://bdd-qinyu.v2.tenxapp.com:41922";
  }

  @Test
  public void should_go_to_login_page_if_click_login(){
    open("/");
    assertThat(title(), containsString("BDD 工作坊"));
    $(linkText("Log in")).click();
    $("#user_login").should(appear);
  }

  @Test
  public void should_login_wordpress_with_correct_credentials() {
    gotoLoginPage();
    String user = "admin";
    String pass = "123456";
    login_with_credentials(user, pass);
    $("#wp-admin-bar-my-account").should(appear);
    assertThat(url(), containsString("wp-admin"));
  }

  static void login_with_credentials(String user, String pass) {
    $("#user_login").sendKeys(user);
    $("#user_pass").sendKeys(pass);
    $("#wp-submit").click();
  }


  static void gotoLoginPage() {
    open("/wp-login.php");
  }
}
