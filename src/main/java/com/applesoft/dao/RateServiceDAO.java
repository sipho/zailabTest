package com.applesoft.dao;

import com.applesoft.dbmanager.ConnectionManager;
import com.applesoft.model.RateServiceModel;
import com.applesoft.model.RateServiceResponseModel;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Sipho on 04/09/2017.
 */
@Component
public class RateServiceDAO {
  private static String BRANCH_NAME = "branchName";
  private static String RATE_SERVICE = "rateService";
  private static String START_DATE = "startDate";
  private static String END_DATE = "endDate";
  private static final Logger logger = LoggerFactory.getLogger(RateServiceDAO.class);
  private Session getSession(){
    Session session = new ConnectionManager().getSessionFactory().openSession();
    session.beginTransaction();
    return session;
  }

  /**
   * Save rate.
   *
   * @param rateServiceModel the rate service model
   * @return {@Link RateServiceModel}
   */
  public RateServiceModel saveServiceRating(RateServiceModel rateServiceModel){
    logger.info("Saving data started, branchName: " + rateServiceModel.getBranchName() + ", rateService: " + rateServiceModel.getRateService());
    Session session = getSession();
    session.save(rateServiceModel);
    session.getTransaction().commit();
    logger.info("Done saving, branchName: " + rateServiceModel.getBranchName() + ", rateService: " + rateServiceModel.getRateService());
    return rateServiceModel;
  }

  /**
   * Get service rates
   * @param rateService
   * @param startDate
   * @param endDate
   * @return
   */
  public List<RateServiceResponseModel> getServiceRatings(String rateService, String startDate, String endDate){
    List list = retrieveData(rateService, startDate, endDate);
    List<RateServiceResponseModel> rateServiceResponseModels = new ArrayList<>();
    list.forEach(object ->
      rateServiceResponseModels.add(buildRateServiceResponseModel(object))
    );

    return rateServiceResponseModels;
  }

  private RateServiceResponseModel buildRateServiceResponseModel(Object object){
    Object[] objects = (Object[]) object;
    RateServiceResponseModel rateServiceResponseModel = new RateServiceResponseModel();
    rateServiceResponseModel.setBranchName((String)objects[0]);
    rateServiceResponseModel.setTotalHappiness((Long)objects[1]);
    return rateServiceResponseModel;
  }

  private List retrieveData(String rateService, String startDate, String endDate) {
    Session session = getSession();
    if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
      return session.createQuery(
          "select branchName, count(*) from RateServiceModel where rateService = :rateService and date > :startDate and date < :endDate group by branchName")
          .setParameter(RATE_SERVICE, rateService)
          .setParameter(START_DATE, startDate)
          .setParameter(END_DATE, endDate)
          .list();
    } else if (startDate != null && !startDate.isEmpty()) {
      return session.createQuery(
          "select branchName, count(*) from RateServiceModel where rateService = :rateService and date > :startDate group by branchName")
          .setParameter(RATE_SERVICE, rateService)
          .setParameter(START_DATE, startDate)
          .list();
    } else if (endDate != null && !endDate.isEmpty()) {
      return session
          .createQuery(
              "select branchName, count(*) from RateServiceModel where rateService = :rateService and date < :endDate group by branchName")
          .setParameter(RATE_SERVICE, rateService)
          .setParameter(END_DATE, endDate)
          .list();
    } else {
      return session.createQuery(
          "select branchName, count(*) as total from RateServiceModel where rateService = :rateService group by branchName")
          .setParameter(RATE_SERVICE, rateService)
          .list();
    }
  }
}