package com.telRan.addressbook.tests;

import com.telRan.addressbook.model.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void precondition(){
    app.getGroupHelper().openGroupsPage();
    if(!app.getGroupHelper().isGroupPresent()){

      app.getGroupHelper().createGroup();
    }

  }

  @Test
  public void testGroupModification() {
    app.getGroupHelper().openGroupsPage();
    int before = app.getGroupHelper().getGroupsCount();

    app.getGroupHelper().selectGroupByIndex(before-1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new Group()
            .setGroupHeader("modifyed")
            .setGroupName("new")
            .setGroupFooter("Changed"));
    app.submitModification();
    app.getGroupHelper().returnToGroupsPage();

    int after = app.getGroupHelper().getGroupsCount();

    Assert.assertEquals(after,before);

  }

}
