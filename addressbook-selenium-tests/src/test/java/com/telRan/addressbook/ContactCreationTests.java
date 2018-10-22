package com.telRan.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.initContactCreation();
    app.fillContactForm("Haim","Mizrahi","Zarhin 7,Raanana","097413333","xeppottuttux-7403@yopmail.com");
    app.submitCreation();


  }

}
