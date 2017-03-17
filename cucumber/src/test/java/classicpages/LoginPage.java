package classicpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasicPage {

  @FindBy(id = "user_login")
  WebElement userInput;

  @FindBy(id = "user_pass")
  WebElement passInput;

  @FindBy(id = "wp-submit")
  WebElement submitButton;

  @FindBy(id = "login_error")
  WebElement errorMessage;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void login(String user, String pass) {
    userInput.sendKeys(user);
    passInput.sendKeys(pass);
    submitButton.click();
  }

  public WebElement getErrorMessage() {
    return errorMessage;
  }
}
