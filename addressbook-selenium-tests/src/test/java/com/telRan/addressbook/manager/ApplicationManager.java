package com.telRan.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private SessionHelper sessionHelper;
  WebDriver wd;
  private GroupHelper groupHelper;
  private NavigationHelper navigationHelper;




  public void start() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    navigationHelper.openSite("http://localhost/addressbook");
    sessionHelper = new SessionHelper(wd);
    groupHelper = new GroupHelper(wd);
    sessionHelper.login("admin", "secret");

    navigationHelper = new NavigationHelper(wd);

  }



  public void stop() {
    wd.quit();
  }

  public void submitModification() {
    groupHelper.click(By.name("update"));
  }

  public void submitCreation() {
    groupHelper.click(By.name("submit"));
  }

  public void fillContactForm(String name, String lastName, String address, String phone, String email) {
    groupHelper.type(By.name("firstname"), name);
    groupHelper.type(By.name("lastname"), lastName);
    groupHelper.type(By.name("address"), address);
    groupHelper.type(By.name("work"), phone);
    groupHelper.type(By.name("email"), email);
  }

  public void initContactCreation() {
    groupHelper.click(By.cssSelector("a[href='edit.php']"));
  }

  public void contactDeletion() {
    groupHelper.click(By.cssSelector("[onclick='DeleteSel()']"));
    wd.switchTo().alert().accept();
  }

  public void contactSelect() {
    groupHelper.click(By.name("selected[]"));
  }

  public void submitContactModification() {
    groupHelper.click(By.name("update"));
  }

  public void initContactModificion() {
    groupHelper.click(By.cssSelector("[title='EDIT']"));
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
