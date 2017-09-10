package com.acme.test01.siphomashapa.model;

/**
 * Created by Sipho on 10/09/2017.
 */
public class ACMERequestModel {
  private int id;
  private String accountId;
  private String balance;
  private String accountBalance;
  private String accountType;

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public String getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(String accountBalance) {
    this.accountBalance = accountBalance;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }
}
