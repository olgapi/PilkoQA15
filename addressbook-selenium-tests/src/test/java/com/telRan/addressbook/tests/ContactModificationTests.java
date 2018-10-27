package com.telRan.addressbook.tests;

import com.telRan.addressbook.model.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void precondition(){

    if(!app.getContactHelper().isContactPresent()){

      app.getContactHelper().createContact();
    }

  }
  @Test
  public void TestContactModification() {


    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new Contact()
            .setName("VovaAAAAAA")
            .setLastName("Pilko")
            .setAddress("Zarhin 7,Raanana")
            .setPhone("0545555555")
            .setEmail("vladimir-7403@yopmail.com"));

    app.getContactHelper().submitContactModification();

  }

}
