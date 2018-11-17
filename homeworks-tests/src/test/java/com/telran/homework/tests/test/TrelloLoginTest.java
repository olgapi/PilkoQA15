package com.telran.homework.tests.test;

import com.telran.homework.tests.model.Account;
import org.testng.annotations.Test;

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
