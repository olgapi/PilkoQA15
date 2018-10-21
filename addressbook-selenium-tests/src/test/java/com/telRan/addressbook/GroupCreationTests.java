package com.telRan.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    openGroupsPage();
    initGroupCreation();
    fillGroupForm(new Group()
            .setGroupName("Qa15")
            .setGroupHeader("ghhhh")
            .setGroupFooter("footer"));

    submitGroupCreation();
    returnToGroupsPage();
  }

}

