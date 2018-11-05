package com.telRan.addressbook.tests;

import com.telRan.addressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {


    int before = app.getContactHelper().getContactsCount();

    app.getContactHelper().initContactCreation();

    app.getContactHelper().fillContactForm(new Contact()
            .setName("Haim")
            .setLastName("Mizrahi")
            .setAddress("Zarhin 7,Raanana")
            .setPhone("097413333")
            .setEmail("xeppottuttux-7403@yopmail.com"));

    app.getContactHelper().submitContactCreation();


    int after = app.getContactHelper().getContactsCount();
    Assert.assertEquals(after, before + 1);


  }


}
