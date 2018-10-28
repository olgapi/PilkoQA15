package com.telran.homework.tests.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;
  private TrelloHelper trelloHelper;
  private NavigationHelper navigationHelper;

  public void start() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    navigationHelper = new NavigationHelper(wd);
    navigationHelper.openSite("https://trello.com");
    trelloHelper = new TrelloHelper(wd);
  }

  public void stop() {
    wd.quit();
  }

  public TrelloHelper getTrelloHelper() {
    return trelloHelper;
  }
}