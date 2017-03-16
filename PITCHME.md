# Cucumber Workshop

Practice cucumber-java and selenide(selenium)

---

# Prerequisites
1. JDK installed
2. Maven installed and [mavenCental](https://search.maven.org/) can be reached
3. IDE with Cucumber and Maven plugin installed(Intellij IDEA Community Edition is recommended)
4. Browser and corresponding driver installed

---

# Agenda
* "Hello World"
* Finish First Feature Test
* Test Report
* Add more "Happy" feartures
* Add other features
...

+++

# Agenda(Cont.)
* Hooks
* Waits
* Refactor
* Tags
* @CucumberOptions

---

# "Hello World"

Create cucumber project

+++

### 0. Go throuth SUT(Wordpress Blog)
http://bdd-qinyu.v2.tenxapp.com:41922  
User: admin  
Pass: 123456  

+++ 

###  1. Create maven project and add dependencies:
* info.cukes:cucumber-java:1.2.5
* info.cukes:cucumber-junit:1.2.5
* junit:junit:4.12

```xml
<dependency>
    <groupId>info.cukes</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>1.2.5</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>info.cukes</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>1.2.5</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
``` 
<!-- .element: class="fragment" -->

+++

### 2. Add first feature using [Gherkin](https://github.com/cucumber/cucumber/wiki/Gherkin)

* Should be in folder `src/test/resources`

```gherkin
Feature: Login WordPress
    Scenario: Successful open login page
        Given open the home page
        When click login
        Then open the login page successful
``` 

+++

### 3. Add test

```java
@RunWith(Cucumber.class)
public class LoginTest {
}
``` 

+++

### 4. Run test and watch output 
```sh
mvn test
# Get more help by using arguement -Dcucumber.options="--help"
```

---

# Finish First Fearture Test

Playing with Selenide/Selenium

+++

### 1. Create a new java file "MySetpDefs.java" with following snippets from console output

```java
@Given("^open the home page$")
public void open_the_home_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^click login$")
public void click_login() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^open the login page successful$")
public void open_the_login_page_successful() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}
```

+++

### 2. Run test and watch the output
```sh
mvn test
```

+++

### 3. Add **Selenide** dependency
com.codeborne:selenide:4.3  

```xml
<dependency>
    <groupId>com.codeborne</groupId>
    <artifactId>selenide</artifactId>
    <version>4.3</version>
    <scope>test</scope>
</dependency>
```
<!-- .element: class="fragment" -->

+++

### 4. [Quick Start](http://selenide.org/quick-start.html) with **Selenide**

```java
import static com.codeborne.selenide.Selenide.*;

// Navigate to webpage
open(String url); 
// Find web element by its text and click on it
$(By.linkText(String text)).click() 
// Return current page's title 
title(); 
// Return current page's url
url(); 
```

```java
@Given("^open the home page$")
public void open_the_home_page() throws Throwable {
    open("http://bdd-qinyu.v2.tenxapp.com:41922");
}

@When("^click login$")
public void click_login() throws Throwable {
    $(By.linkText("Log in")).click();
}

@Then("^open the login page successful$")
public void open_the_login_page_successful() throws Throwable {
    assertThat(url(), containsString("login.php"));
}
```
<!-- .element: class="fragment" -->

+++

### 5. [HAMCHREST](https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki)

```java
// JUnit 4 for equals check
assertEquals(expected, actual);
// Hamcrest for equals check
assertThat(actual, is(equalTo(expected)));

// JUnit 4 for not equals check
assertFalse(expected.equals(actual));
// Hamcrest for not equals check
assertThat(actual, is(not(equalTo(expected))));
```

<!--Chrome Web Developer Tools-->

+++

### 6. Run test and watch the output

```sh
# Selenide starts firefox by default, change to chorme by using -Dselenide.browser="chrome" argument
mvn test -Dselenide.browser="chrome"
```

---

# Test Report

+++

### 1. Run test and watch the output
```sh
# You can list plugin options by using arguement -Dcucumber.options="--help"
mvn test -Dselenide.browser="chrome" -Dcucumber.options="--plugin html:target/cucumber"
mvn test -Dselenide.browser="chrome" -Dcucumber.options="--plugin html:target/cucumber --plugin json:target/cucumber.json"
```

+++

### 2. Cucumber Reports
```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>net.masterthought</groupId>
                <artifactId>maven-cucumber-reporting</artifactId>
                <version>3.5.0</version>
                <executions>
                    <execution>
                        <id>execution</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <projectName>cucumber-jvm-example</projectName>
                            <outputDirectory>${project.build.directory}/cucumber</outputDirectory>
                            <cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
                            <parallelTesting>false</parallelTesting>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

    <dependency>
        <groupId>net.masterthought</groupId>
        <artifactId>maven-cucumber-reporting</artifactId>
        <version>3.5.0</version>
    </dependency>
```

+++

### 3. Generate Cucumber Reports
```sh
mvn verify  -Dselenide.browser="chrome" -Dcucumber.options="--plugin html:target/cucumber --plugin json:target/cucumber.json"
```

---

# Add More "Happy" Features

+++

### 1. Add login success feature
```gherkin
Scenario: Login WordPress successfully
    Given open the home page
    When click login
    When login with username "admin" and password "admin123" 
    Then login successfully
```
<!-- .element: class="fragment" -->

+++

### 2. Run test and watch the output
```sh
mvn test -Dselenide.browser="chrome"
```
or  <!-- .element: class="fragment" -->
```sh
mvn test -Dcucumber.options="--dry-run"
```
<!-- .element: class="fragment" -->

+++

### 3. Copy Step Definition snippets from output

> Or you can generate step definitions using IDE feature  <!-- .element: class="fragment" -->

```java
@When("^login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
public void loginWithUsernameAndPassword(String user, String pass) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^login successfully$")
public void loginSuccessfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}
```

+++

### 4. Implement Steps by Selenide
```java
import static com.codeborne.selenide.Selenide.*;

// Find web element by jquery like cssSelector and click on it
$(String cssSelector).click() 
// Find web element by jquery like cssSelector and input characters
$(String cssSelector).sendKeys(CharSequence charSequence) 
```

```java
@When("^login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
public void loginWithUsernameAndPassword(String user, String pass) throws Throwable {
    $("#user_login").sendKeys(user);
    $("#user_pass").sendKeys(pass);
    $("#wp-submit").click();
}

@Then("^login successfully$")
public void loginSuccessfully() throws Throwable {
    assertThat(url(), containsString("wp-admin"));
}
```
<!-- .element: class="fragment" -->

+++

### 5. Run test and watch the output

```sh
mvn test -Dselenide.browser="chrome"
```


---

# Add other features

"Unhappy" paths

+++

### 1. Add login failure feature and Stef Definitions

```gherkin
  Scenario: login WordPress failed
    Given open the home page
    When click login
    When login with username "admin" and password "1234567"
    Then login failed with message "ERROR: The password you entered for the username admin is incorrect. Lost your password?"
```
<!-- .element: class="fragment" -->

```java
  @Then("^login failed with message \"([^\"]*)\"$")
  public void loginFailedWithMessage(String arg0) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
```
<!-- .element: class="fragment" -->

+++

### 2. Implement Step
```java
import static com.codeborne.selenide.Condition.*;

// Assert that web element has expected text
$(String cssSelector).shouldHave(text(String expectedText))
```

```java
  @Then("^login failed with message \"([^\"]*)\"$")
  public void loginFailedWithMessage(String errorMessage) throws Throwable {
    $("#login_error").shouldHave(text(errorMessage));
  }
```
<!-- .element: class="fragment" -->

+++

### 3. Run test and watch the output

```sh
mvn test -Dselenide.browser="chrome"
```

+++

### 4. Oops!!
```java
Caused by: NoSuchElementException: no such element: Unable to locate element: {"method":"link text","selector":"Log in"}
        at com.codeborne.selenide.impl.WebElementSource.createElementNotFoundError(WebElementSource.java:31)
        at com.codeborne.selenide.impl.ElementFinder.createElementNotFoundError(ElementFinder.java:82)
        at com.codeborne.selenide.impl.WebElementSource.checkCondition(WebElementSource.java:59)
        at com.codeborne.selenide.impl.WebElementSource.findAndAssertElementIsVisible(WebElementSource.java:72)
        at com.codeborne.selenide.commands.Click.execute(Click.java:14)
        at com.codeborne.selenide.commands.Click.execute(Click.java:11)
```
<!-- .element: class="fragment" -->
> Screenshots and source in `build/reports/tests`
<!-- .element: class="fragment" -->

---

# Hooks

“Setup” and "Teardown" for each **Scenario**

+++

### 1. Create `Hooks.java`
```java
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
  @Before
  public void beforeScenario() {
  }

  @After
  public void afterScenario() {
  }
}
```

+++

### 2. Implement hooks
```java
import static com.codeborne.selenide.WebDriverRunner.*;
import com.codeborne.selenide.Configuration;

// Close browser
closeWebDriver();

// Wait how many milliseconds before test fails
Configuration.timeout = 6000;
// Which browser to use
Configuration.browser = "chrome";
```
```java
  @Before
  public void beforeScenario() {
    Configuration.timeout = 6000;
    Configuration.browser = "chrome";
  }

  @After
  public void afterScenario() {
    closeWebDriver();
  }
```
<!-- .element: class="fragment" -->

+++

### 3. Run test and watch the output

```sh
mvn test
```

---

# Waits

Sometimes tests are flaky

+++

### 1. Implicict Wait
```java
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

// Wait until given element meet given conditions.
$(String cssSelector).waitUntil(Condition condition, long millisecondsTimeout);
// Wait until given element does not meet given conditions.
$(String cssSelector).waitWhile(Condition condition, long millisecondsTimeout);

Wait().until(Predicate<T> isTrue);
```
```java
$("#user_login").waitUntil(appear, 8000).sendKeys(user);
```

+++

### 2. Explicit Wait
```java
import static com.codeborne.selenide.Selenide.*;

sleep(2000);
```

+++

### 3. Run test and watch the output

```sh
mvn test
```

---

# Refactor 
Code smells

+++

### 1. Duplicated Code
```gherkin
  Scenario: Successful open login page
    Given open the home page
    When click login
    ...

  Scenario: login WordPress Successfully
    Given open the home page
    When click login
    ...

  Scenario: login WordPress failed
    Given open the home page
    When click login
    ...
```
<!-- .element: class="fragment" -->

+++

### 2. Feature backagroud

```gherkin
Feature: Login WordPress
  Background:
    Given open the home page
    When click login

  Scenario: Successful open login page
    Then open the login page successful

  Scenario: login WordPress Successfully
    When login with username "admin" and password "123456"
    Then login successfully

  Scenario: login WordPress failed
    When login with username "admin" and password "1234567"
    Then login failed with message "ERROR: The password you entered for the username admin is incorrect. Lost your password?"
```

+++

### 3. Run test and watch the output

```sh
mvn test
```

+++

### 4. Add more fail scenarios
```gherkin
Scenario: login WordPress failed invalid username
    When login with username "qinyu" and password "123456"
    Then login failed with message "ERROR: Invalid username. Lost your password?"

Scenario: login WordPress failed empty pass
    When login with username "admin" and password ""
    Then login failed with message "ERROR: The password field is empty."
```
<!-- .element: class="fragment" -->

+++

### 5. Run test and watch the output

```sh
mvn test
```

+++

### 6. Duplicated code

```gherkin
Scenario: login WordPress failed wrong pass
    When login with username "<...>" and password "<..>"
    Then login failed with message "<...>"

Scenario: login WordPress failed invalid username
    When login with username "<...>" and password "<..>"
    Then login failed with message "<...>"

Scenario: login WordPress failed empty pass
    When login with username "<...>" and password "<..>"
    Then login failed with message "<...>"
```
<!-- .element: class="fragment" -->

+++

### 7. Scenario Outline
```gherkin
Scenario Outline: login WordPress failed
    When login with username "<user>" and password "<password>"
    Then login failed with message "<error>"
    Examples:
      | user  | password | error                                                                                    |
      | admin | 111111   | ERROR: The password you entered for the username admin is incorrect. Lost your password? |
      | qinyu | 123456   | ERROR: Invalid username. Lost your password?                                             |
      | admin |          | ERROR: The password field is empty.                                                      |
```

+++

### 5. Run test and watch the output

```sh
mvn test
```

---

# Tags

Organize features and catrgorize scenarios

+++

### 1. Try tags in features

```gherkin
Feature: Login WordPress
  Background:
    Given open the home page
    When click login
  
  @happy @smoke
  Scenario: Successful open login page
    Then open the login page successful
```

+++

### 2. Run test and watch the output

```sh
mvn test -Dcucumber.options="--tags @smoke"
```

+++

### 3. Tag expressions
```sh
--tags @smoke --tags @happy # and
--tags @smoke,@happy # or
--tags ~@smoke # not
```

---

# @CucumberOptions

Other useful options

+++

### Useful options
```java
@CucumberOptions(
    features = "src/test/resources", // Where to find Features
    glue = "steps", // Where to find step definitions
    plugin = {"pretty" , "html:target/cucumber"}, // output format(s)
    snippets = SnippetType.CAMELCASE, // Snippets' case when generated
    tags = {"@smoke", "~@happy"} // Tags
)
```










