package com.telRan.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
  WebDriver wd;

  @BeforeClass
  public void setUp() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook");

    //login
    login("admin", "secret");


  }

  public void login(String userName, String password) {
    type(By.name("user"), userName);

    type(By.name("pass"), password);
    wd.findElement(By.cssSelector("[type='submit']")).click();
  }

  public void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void returnToGroupsPage() {

    wd.findElement(By.cssSelector("i a[href='group.php']")).click();
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(Group group) {
    type(By.name("group_name"), group.getGroupName());
    type(By.name("group_header"), group.getGroupHeader());
    type(By.name("group_footer"), group.getGroupFooter());
  }

  public void initGroupCreation() {

    wd.findElement(By.name("new")).click();
  }

  public void openGroupsPage() {
    wd.findElement(By.cssSelector("[href='group.php']")).click();
  }

  @AfterClass
  public void tearDown() {
    wd.quit();
  }

  public void submitModification() {
    wd.findElement(By.name("update")).click();
  }

  public void initGroupModification() {
    wd.findElement(By.cssSelector("[name=edit]:last-child")).click();
  }

  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }



  public void deleteGroup() {
    wd.findElement(By.name("delete")).click();
  }
  public boolean isElementPresent(By locator) {

    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  public boolean isGroupPresent(){
    isElementPresent(By.name("selected[]"));
    return true;
    //return isElementPresent(By.name("selected[]"));eshe variant zapisi

  }

  public void createGroup() {
    initGroupCreation();
    fillGroupForm(new Group()
            .setGroupName("Qa15")
            .setGroupHeader("ghhhh")
            .setGroupFooter("footer"));

    submitGroupCreation();
    returnToGroupsPage();
  }


  public void submitCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillContactForm(String name, String lastName, String address, String phone, String email) {
    type(By.name("firstname"), name);
    type(By.name("lastname"), lastName);
    type(By.name("address"), address);
    type(By.name("work"), phone);
    type(By.name("email"), email);
  }

  public void initContactCreation() {
    wd.findElement(By.cssSelector("a[href='edit.php']")).click();
  }

  public void contactDeletion() {
    wd.findElement(By.cssSelector("[onclick='DeleteSel()']")).click();
    wd.switchTo().alert().accept();
  }

  public void contactSelect() {
    wd.findElement(By.name("selected[]")).click();
  }

  public void submitContactModification() {
    wd.findElement(By.name("update")).click();
  }

  public void initContactModificion() {
    wd.findElement(By.cssSelector("[title='EDIT']")).click();
  }
}
