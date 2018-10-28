package com.telran.homework.tests.manager;


import com.telran.homework.tests.model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrelloHelper extends HelperBase {


  public TrelloHelper(WebDriver wd) {
    super(wd);
  }

  public void initLogin() {
    click(By.cssSelector("[class='header-button-secondary']"));
  }

  public void fillLoginForm(Account account) {

    type(By.name("user"), account.getUserName());

    type(By.name("password"), account.getPassword());
  }

  public void submitLogin() {
    click(By.cssSelector("[type='submit']"));
  }

}
