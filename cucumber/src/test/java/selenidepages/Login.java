package selenidepages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class Login {

  private final SelenideElement userInput = $("#user_login");
  private final SelenideElement passInput = $("#user_pass");
  private final SelenideElement submitButton = $("#wp-submit");

  public void login(String user, String pass) {
    userInput.waitUntil(appear, 8000).sendKeys(user);
    sleep(500);
    passInput.sendKeys(pass);
    submitButton.click();
  }

  public SelenideElement errorMessage() {
    return $("#login_error");
  }

}
