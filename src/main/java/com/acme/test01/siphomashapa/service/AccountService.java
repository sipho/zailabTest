package com.acme.test01.siphomashapa.service;

import javax.security.auth.login.AccountNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
  public void openSavingsAccount(Long accountId, Long amountToDeposit);
  public void openCurrentAccount(Long accountId);
  public void withdraw(Long accountId, int amountToWithdraw, String acountType)
      throws AccountNotFoundException;
  public void deposit(Long accountId, int amountToDeposit, String acountType)
      throws AccountNotFoundException;
}