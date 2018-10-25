package com.telran.homework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TrelloLoginTest extends TestBase {

  WebDriver wd;
  @BeforeClass
  public void setUp(){
    wd = new ChromeDriver();

    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    wd.navigate().to("https://trello.com/");
  }
  @Test
  public void testTrelloLogin()
  {
    initLogin();
    fillLoginForm(new Account().setUserName("olga.pilko@gmail.com").setPassword("arik2008"));
    submitLogin();

  }

  public void submitLogin() {
    click(By.cssSelector("[type='submit']"));
  }

  public void initLogin() {
    click(By.cssSelector("[class='header-button-secondary']"));
  }

  public void fillLoginForm(Account account) {


    type(By.name("user"), account.userName);

    type(By.name("password"), account.password);
  }


  public void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }
  public void click(By locator) {
    wd.findElement(locator).click();
  }

  @AfterClass
  public void tearDown(){
    //wd.quit();
  }

}
