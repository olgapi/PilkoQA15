package com.telRan.addressbook.tests;

import com.telRan.addressbook.model.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTests extends TestBase {
 // Logger logger = LoggerFactory.getLogger(GroupCreationTests.class);

 //potom perenesli v TestBase

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {


    List<Object[]> list = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new FileReader(new File("src\\test\\resources\\groups.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[]{new Group()
              .setGroupName(split[0])
              .setGroupHeader(split[1])
              .setGroupFooter(split[2])});
      line = reader.readLine();
    }
    /*list.add(new Object[]{"test1","header1","footer1"});
    list.add(new Object[]{"test2","header2","footer2"});
    list.add(new Object[]{"t","h","f"});
    list.add(new Object[]{"looooooong","heeeeeeeeeader","foooooooter"});
    list.add(new Object[]{"","",""});
*/


    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(Group group) {
  logger.info("Start testGroupCreation");//potom perenesetsya v TestBase

    app.getGroupHelper().openGroupsPage();
    int before = app.getGroupHelper().getGroupsCount();

    app.getGroupHelper().initGroupCreation();

    app.getGroupHelper().fillGroupForm(group);
          //  .setGroupName(groupName)
           // .setGroupHeader(groupHeader)
           // .setGroupFooter(groupFooter));

    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();

    int after = app.getGroupHelper().getGroupsCount();

    Assert.assertEquals(after, before + 1);
    logger.info("Stop testGroupCreation");//potom perenesem v TestBase
  }

}

