package com.telRan.addressbook.model;

public class Contact {

  private String name = "";
  private String lastName = "";
  private String address = "";
  private String phone = "";
  private String email = "";

  public String getName() {
    return name;
  }

  public Contact setName(String name) {
    this.name = name;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Contact setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Contact setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public Contact setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Contact setEmail(String email) {
    this.email = email;
    return this;
  }
}
