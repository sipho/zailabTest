package com.acme.test01.siphomashapa.resources;

import com.acme.test01.siphomashapa.service.AccountService;
import javax.security.auth.login.AccountNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sipho on 10/09/2017.
 */
@Path("v1/{accountId}")
@RestController
public class ACMEBankResource {
  private static final Logger logger = LoggerFactory.getLogger(ACMEBankResource.class);
  @Autowired
  private AccountService accountService;

  /**
   * open savings account
   * @param accountId
   * @param amountToDeposit
   * @return {@Link Response}
   */

  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  @RequestMapping(method = RequestMethod.POST, value = "/acme/v1/{accountId}/savings",
      produces = MediaType.APPLICATION_JSON)
  public String openSavingsAccount(@PathParam("accountId") @PathVariable(name = "accountId") Long accountId,
      @QueryParam("amountToDeposit") @RequestParam(name = "amountToDeposit", required = true) Long amountToDeposit) {
    logger.info("POST Request, accountId: " + accountId + ", amountToDeposit: " + amountToDeposit);
    //if ()
    accountService.openSavingsAccount(accountId, amountToDeposit);
    return "Savings account has been created for accountId: " + accountId;
  }

  /**
   * open savings account
   * @param accountId
   * @param amountToDeposit
   * @return {@Link Response}
   */

  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  @RequestMapping(method = RequestMethod.POST, value = "/acme/v1/{accountId}/current",
      produces = MediaType.APPLICATION_JSON)
  public String openCurrentAccount(@PathParam("accountId") @PathVariable(name = "accountId") Long accountId,
      @QueryParam("amountToDeposit") @RequestParam(name = "amountToDeposit", required = true) Long amountToDeposit) {
    logger.info("POST Request, accountId: " + accountId + ", amountToDeposit: " + amountToDeposit);
    accountService.openSavingsAccount(accountId, amountToDeposit);
    return "Current account has been created for accountId: " + accountId;
  }


  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  @RequestMapping(method = RequestMethod.GET, value = "/acme/v1/{accountId}",
      produces = MediaType.APPLICATION_JSON)
  public void withdraw(@PathParam("accountId") @PathVariable(name = "accountId") Long accountId,
      @QueryParam("amountToWithdraw") @RequestParam(name = "amountToWithdraw", required = true) int amountToWithdraw,
      @QueryParam("accountType") @RequestParam(name = "accountType", required = true) String accountType) {
    logger.info("GET Request, accountId: " + accountId + ", amountToWithdraw: " + amountToWithdraw);

    try {
      accountService.withdraw(accountId, amountToWithdraw, accountType);
    } catch (AccountNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  @RequestMapping(method = RequestMethod.PUT, value = "/acme/v1/{accountId}",
      produces = MediaType.APPLICATION_JSON)
  public void deposit(@PathParam("accountId") @PathVariable(name = "accountId") Long accountId,
      @QueryParam("amountToDeposit") @RequestParam(name = "amountToDeposit", required = true) int amountToDeposit,
      @QueryParam("accountType") @RequestParam(name = "accountType", required = true) String accountType) {
    logger.info("PUT Request, accountId: " + accountId + ", amountToWithdraw: " + amountToDeposit);
    try {
      accountService.deposit(accountId, amountToDeposit, accountType);
    } catch (AccountNotFoundException e) {
      e.printStackTrace();
    }
  }

}
