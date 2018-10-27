package com.telRan.addressbook.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private SessionHelper sessionHelper;
  WebDriver wd;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;

  private NavigationHelper navigationHelper;




  public void start() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    navigationHelper = new NavigationHelper(wd);
    navigationHelper.openSite("http://localhost/addressbook");
    sessionHelper = new SessionHelper(wd);
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper.login("admin", "secret");



  }



  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
  public ContactHelper getContactHelper() {
    return contactHelper;
  }


  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
