package pageutils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Login {
  public static void login(String user, String pass) {
    $("#user_login").waitUntil(appear, 8000).sendKeys(user);
    sleep(500);
    $("#user_pass").sendKeys(pass);
    $("#wp-submit").click();
  }

  public static SelenideElement errorMessage() {
    return $("#login_error");
  }
}
