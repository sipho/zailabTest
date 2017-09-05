package com.applesoft.model;

/**
 * Created by Sipho on 04/09/2017.
 */
public class RateServiceModel{
  private int id;
  private String branchName;
  private String rateService;
  private String date;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  public String getRateService() {
    return rateService;
  }

  public void setRateService(String rateService) {
    this.rateService = rateService;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
