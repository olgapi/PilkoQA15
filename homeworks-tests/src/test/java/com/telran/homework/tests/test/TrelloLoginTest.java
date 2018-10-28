package com.telran.homework.tests.test;

import com.telran.homework.tests.model.Account;
import com.telran.homework.tests.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TrelloLoginTest extends TestBase {

  @Test
  public void testTrelloLogin()
  {
    app.getTrelloHelper().initLogin();
    app.getTrelloHelper().fillLoginForm(new Account()
            .setUserName("olga.pilko@gmail.com")
            .setPassword("arik2008"));
    app.getTrelloHelper().submitLogin();

  }

}
