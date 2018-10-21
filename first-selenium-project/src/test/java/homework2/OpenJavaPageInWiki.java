package homework2;

import com.telran.qa15.sandbox.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenJavaPageInWiki extends TestBase {

  @Test
  public void OpenWikiJavaTest (){


    typeInFieldSearch();

    clickOnTheButtonSearch();



    String currentUrl = wd.getCurrentUrl();
    Assert.assertEquals("currentUrl","https://en.wikipedia.org/wiki/Java");

  }

}
