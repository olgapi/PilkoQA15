package com.telRan.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void precondition(){
    openGroupsPage();
    if(!isGroupPresent()){

      createGroup();
    }

  }

  @Test
  public void testGroupDeletion(){
    openGroupsPage();
    selectGroup();
    deleteGroup();
    returnToGroupsPage();
  }

}
