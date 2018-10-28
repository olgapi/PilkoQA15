package com.telran.homework.tests.test;

import com.telran.homework.tests.manager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {


  protected ApplicationManager app = new ApplicationManager();

  @BeforeClass
  public void setUp() {
    app.start();
  }

  @AfterClass
  public void tearDown() {
    app.stop();
  }
}

