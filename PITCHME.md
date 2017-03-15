# Cucumber Workshop

Practice cucumber-java and selenide(selenium)

---

# Prerequisites
1. JDK installed
2. Maven installed and mavenCental can be reached
3. IDE with Cucumber and Maven plugin installed(Intellij IDEA Community Edition is recommended)
4. Browser and corresponding driver installed 

---

# Agenda
1. "Hello World"
2. Finish First Feature Test
3. Test Report
4. Add more feartures

---

# "Hello World"

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

+++

1. Create a new java file "MySetpDefs.java" with following snippets from console output
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

2. Run test and watch the output
```sh
mvn test
```

+++

3. Add **Selenide** dependency
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

<!--hamcrest-->
4. [Quick Start](http://selenide.org/quick-start.html) with **Selenide**
```java
import static com.codeborne.selenide.Selenide.*;

open(String url); // Navigate to webpage
$(By.linkText(String text)).click() // Find web element by its text and click on it
title(); // Return current page's title 
url(); // Return current page's url
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

[HAMCHREST](https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki)

<!--Chrome Web Developer Tools-->

+++

5. Run test and watch the output
```sh
# Selenide starts firefox by default, change to chorme by using -Dselenide.browser="chrome" argument
mvn test -Dselenide.browser="chrome"
```

---

# Test Report

+++

Run test and watch the output
```sh
# You can list plugin options by using arguement -Dcucumber.options="--help"
mvn test -Dselenide.browser="chrome" -Dcucumber.options="--plugin html:target/cucumber"
```

---

# Add More Features



