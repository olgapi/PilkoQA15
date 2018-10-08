package com.telran.qa15.sandbox.lesson2;

import com.telran.qa15.sandbox.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WikiHomePageTests extends TestBase {

  @Test
  public void testOpeningEnglishWiki(){

    findAndClickOnTheEnglishLink();//findAndClickOnTheEnglishLink
    String currentUrl = wd.getCurrentUrl();//System.out.println(currentUrl);
    Assert.assertEquals(currentUrl,"https://en.wikipedia.org/wiki/Main_Page");
  }

}
