package com.telRan.addressbook;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
  @Test
  public void TestContactModification() {


    initContactModificion();
    fillContactForm("Haim", "Mizrahi", "Zarhin 7,Raanana", "123456677", "xeppottuttux-7403@yopmail.com");

    submitContactModification();


  }

}
