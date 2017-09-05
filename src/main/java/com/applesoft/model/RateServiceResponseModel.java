package com.applesoft.model;

/**
 * Created by Sipho on 04/09/2017.
 */
public class RateServiceResponseModel{
  private String branchName;
  private Long totalHappiness;

  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  public Long getTotalHappiness() {
    return totalHappiness;
  }

  public void setTotalHappiness(Long totalHappiness) {
    this.totalHappiness = totalHappiness;
  }
}
