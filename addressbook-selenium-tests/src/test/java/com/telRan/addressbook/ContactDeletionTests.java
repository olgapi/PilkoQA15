package com.telRan.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {

    contactSelect();
    contactDeletion();
  }

}
