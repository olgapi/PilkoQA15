package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectorsTest {
  WebDriver driver;
  @BeforeMethod
  public void setUp (){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  }
  @Test

  public void TestCssSelector (){
    driver.navigate().to("https://www.google.com/");
    //driver.findElement(By.cssSelector("")).click();
    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
  }

  @AfterMethod

  public void tearDown (){

    //driver.quit();
  }
}
