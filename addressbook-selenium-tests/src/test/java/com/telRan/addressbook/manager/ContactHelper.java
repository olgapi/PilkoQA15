package com.telRan.addressbook.manager;

import com.telRan.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }



  public void submitContactCreation() {
    click(By.name("submit"));
  }
  public void submitContactModification() {
    click(By.name("update"));
  }

  public void fillContactForm(Contact contact) {
    type(By.name("firstname"),contact.getName());
    type(By.name("lastname"), contact.getLastName());
    type(By.name("address"), contact.getAddress());
    type(By.name("work"), contact.getPhone());
    type(By.name("email"), contact.getEmail());

  }

  public void initContactCreation() {

    click(By.cssSelector("a[href='edit.php']"));
  }



  public void initContactModification() {

    click(By.cssSelector("[title='EDIT']"));
  }

  public void selectHome() {
    click(By.cssSelector("a[href='./']"));
  }
  public void selectContact() {
    selectHome();
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    //selectHome(); // TODAy REMOVED
    selectContact(); // TODAY ADDED
    click(By.cssSelector("[onclick='DeleteSel()']"));
    wd.switchTo().alert().accept();
  }

  public boolean isContactPresent(){
    selectHome();
    boolean result =  isElementPresent(By.name("selected[]")); //todo
    return result;

  }

  public void createContact() {
    initContactCreation();
    fillContactForm(new Contact()
            .setName("mmmmmmmmmmmm"));

    submitContactCreation();
  }
  public int getContactsCount() {
    selectHome();
    return wd.findElements(By.name("selected[]")).size();
  }

  public void selectContactByIndex(int index) {
    selectHome();
    wd.findElements(By.name("selected[]")).get(index).click();
  }
}
