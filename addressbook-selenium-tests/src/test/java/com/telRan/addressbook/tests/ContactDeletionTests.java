package com.telRan.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void precondition(){
    if(!app.getContactHelper().isContactPresent()){
      app.getContactHelper().createContact();
    }

  }
  @Test
  public void testContactDeletion() {
    int before = app.getContactHelper().getContactsCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    int after = app.getContactHelper().getContactsCount();

    Assert.assertEquals(after,before-1);
  }

}
