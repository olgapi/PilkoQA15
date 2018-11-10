package com.telRan.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  void sleep(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    }
    catch (InterruptedException e) {
    }
  }


  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void click(By locator) {
    wd.findElement(locator).click();
    sleep(100);
  }

  public boolean isElementPresent(By locator) {

    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
