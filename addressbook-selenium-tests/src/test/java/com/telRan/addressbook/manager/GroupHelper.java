package com.telRan.addressbook.manager;

import com.telRan.addressbook.model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupsPage() {

    click(By.cssSelector("i a[href='group.php']"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(Group group) {
    type(By.name("group_name"), group.getGroupName());
    type(By.name("group_header"), group.getGroupHeader());
    type(By.name("group_footer"), group.getGroupFooter());
  }

  public void initGroupCreation() {

    click(By.name("new"));
  }

  public void openGroupsPage() {
    click(By.cssSelector("[href='group.php']"));
  }

  public void initGroupModification() {
    click(By.cssSelector("[name=edit]:last-child"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void deleteGroup() {
    click(By.name("delete"));
  }

  public boolean isGroupPresent(){

    return isElementPresent(By.name("selected[]"));
    //isElementPresent(By.name("selected[]"));
    //return true;eshe variant zapisi
  }

  public void createGroup() {
    initGroupCreation();
    fillGroupForm(new Group()
            .setGroupName("Qa15")
            .setGroupHeader("ghhhh")
            .setGroupFooter("footer"));

    submitGroupCreation();
    returnToGroupsPage();
  }

  public int getGroupsCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void selectGroupByIndex(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }
}
