package com.telRan.addressbook.tests;

import com.telRan.addressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validContacs() throws IOException {


    List<Object[]> list = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new FileReader(new File("src\\test\\resources\\contacs.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[]{new Contact()
              .setName(split[0])
              .setLastName(split[1])
              .setAddress(split[2])
              .setPhone(split[3])
              .setEmail(split[4])});
      line = reader.readLine();
    }



    return list.iterator();
  }


  @Test(dataProvider = "validContacs")
  public void testContactCreation(Contact contact) {


    int before = app.getContactHelper().getContactsCount();

    app.getContactHelper().initContactCreation();

    app.getContactHelper().fillContactForm(contact);
           /* .setName("Haim")
            .setLastName("Mizrahi")
            .setAddress("Zarhin 7,Raanana")
            .setPhone("097413333")
            .setEmail("xeppottuttux-7403@yopmail.com"));*/

    app.getContactHelper().submitContactCreation();


    int after = app.getContactHelper().getContactsCount();
    System.out.println("before=" + before + " after=" + after);
    Assert.assertEquals(after, before + 1);


  }


}
