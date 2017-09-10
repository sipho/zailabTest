package com.acme.test01.siphomashapa.service;

import com.acme.test01.siphomashapa.dao.ACMEBankDAO;
import com.acme.test01.siphomashapa.model.ACMERequestModel;
import com.acme.test01.siphomashapa.translator.ACMEBankTranslator;
import javax.security.auth.login.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by x450658 on 10/09/2017.
 */
@Component
public class AccountServiceImp implements AccountService {

  @Autowired
  private ACMEBankTranslator acmeBankTranslator;
  @Autowired
  private ACMEBankDAO acmeBankDAO;
  @Override
  public void openSavingsAccount(Long accountId, Long amountToDeposit) {
    if (amountToDeposit < 1000L){

      throw new RuntimeException("Deposit amount is less than R1000, minimum required is a R1000");
    }
    acmeBankDAO.saveAccountInfo(acmeBankTranslator.buildACMERequestModel(accountId, amountToDeposit, "savings", 000));
  }

  @Override
  public void openCurrentAccount(Long accountId) {
    acmeBankDAO.saveAccountInfo(acmeBankTranslator.buildACMERequestModel(accountId, 0L, "current", 000));
  }

  @Override
  public void withdraw(Long accountId, int amountToWithdraw, String acountType) throws AccountNotFoundException {
    ACMERequestModel acmeRequestModel = acmeBankDAO.getAccountInfo(String.valueOf(accountId));
    if (acmeRequestModel == null){
      throw new AccountNotFoundException();
    }
    if (acountType.equals("current")){
      long currentOverDraft = 100000;
      long amountAllowed = Long.valueOf(acmeRequestModel.getBalance()) + currentOverDraft;
      if (amountToWithdraw > amountToWithdraw){
        throw new RuntimeException("Amount to withdraw exceed the amount allowed to withdraw");
      }
    } else if (acountType.equals("savings") && amountToWithdraw > Long.valueOf(acmeRequestModel.getBalance())) {
      throw new RuntimeException("Amount to withdraw exceed the amount allowed to withdraw");
    }
    acmeBankDAO.updateAccountInfo(acmeBankTranslator.buildACMERequestModel(accountId, amountToWithdraw - Integer.valueOf(acmeRequestModel.getBalance()), acountType, acmeRequestModel.getId()));
  }

  @Override
  public void deposit(Long accountId, int amountToDeposit, String acountType) throws AccountNotFoundException {
    ACMERequestModel acmeRequestModel = acmeBankDAO.getAccountInfo(String.valueOf(accountId));
    if (acmeRequestModel == null){
      throw new AccountNotFoundException();
    }
    acmeBankDAO.updateAccountInfo(acmeBankTranslator.buildACMERequestModel(accountId, amountToDeposit + Integer.valueOf(acmeRequestModel.getBalance()), acountType, acmeRequestModel.getId()));
  }
}
