package com.telRan.addressbook.tests;

import com.telRan.addressbook.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.getProperty;

public class TestBase {

  public TestBase() {
  }

  protected static ApplicationManager app = new ApplicationManager(getProperty("browser",BrowserType.CHROME));

  @BeforeSuite
  public void setUp() {
    app.start();
  }

  @AfterSuite(alwaysRun=true)
  public void tearDown() {
    app.stop();
  }
}
