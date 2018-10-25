package com.telran.homework.tests;

public class Account {
  String userName;
  String password;

  public String getUserName() {
    return userName;
  }

  public Account setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public Account setPassword(String password) {
    this.password = password;
    return this;
  }
}
