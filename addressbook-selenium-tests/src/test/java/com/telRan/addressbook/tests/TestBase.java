package com.telRan.addressbook.tests;

import com.telRan.addressbook.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

import static java.lang.System.getProperty;

public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);



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

  @BeforeMethod
  public void logTestStart(Method m){
    logger.info("Start test " + m.getName());
  }

  @AfterMethod
  public void logTestStop(Method m){
    logger.info("Stop test " + m.getName());
  }

}
