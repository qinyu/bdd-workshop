package classicpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yqin on 3/17/17.
 */
public class BasicPage {
  protected WebDriver driver;

  public BasicPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
}
