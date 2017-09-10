package com.acme.test01.siphomashapa.dao;

import com.acme.test01.siphomashapa.dbmanager.ConnectionManager;
import com.acme.test01.siphomashapa.model.ACMERequestModel;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Sipho on 10/09/2017.
 */
@Component
public class ACMEBankDAO {
  private static final Logger logger = LoggerFactory.getLogger(ACMEBankDAO.class);
  private Session getSession(){
    Session session = new ConnectionManager().getSessionFactory().openSession();
    session.beginTransaction();
    return session;
  }

  public void openSavingsAccount(ACMERequestModel acmeRequestModel) {
    saveAccountInfo(acmeRequestModel);
  }

  public void openCurrentAccount(ACMERequestModel acmeRequestModel) {
    saveAccountInfo(acmeRequestModel);
  }

  public void withdraw(ACMERequestModel acmeRequestModel){
    updateAccountInfo(acmeRequestModel);
  }

  public void deposit(ACMERequestModel acmeRequestModel){
    updateAccountInfo(acmeRequestModel);
  }

  /**
   * Save account.
   * @param acmeRequestModel
   * @return {@Link ACMERequestModel}
   */
  public ACMERequestModel saveAccountInfo(ACMERequestModel acmeRequestModel){
    logger.info("Saving data started, accountId: " + acmeRequestModel.getAccountId());
    Session session = getSession();
    session.save(acmeRequestModel);
    session.getTransaction().commit();
    logger.info("Done saving, accountId: " + acmeRequestModel.getAccountId());
    return acmeRequestModel;
  }

  /**
   * update account.
   * @param ACMERequestModel the rate service model
   * @return {@Link ACMERequestModel}
   */
  public ACMERequestModel updateAccountInfo(ACMERequestModel ACMERequestModel){
    logger.info("Update data started, accountId: " + ACMERequestModel.getAccountId());
    Session session = getSession();
    session.update(ACMERequestModel);
    session.getTransaction().commit();
    logger.info("Done updating, accountId: " + ACMERequestModel.getAccountId());
    return ACMERequestModel;
  }

  public ACMERequestModel getAccountInfo(String accountId){
    Session session = getSession();
    return (ACMERequestModel) session.createQuery(
        "from ACMERequestModel where accountId = :accountId")
        .setParameter("accountId", accountId)
        .list().get(0);
  }
}