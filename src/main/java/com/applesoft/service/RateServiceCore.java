package com.applesoft.service;

import com.applesoft.dao.RateServiceDAO;
import com.applesoft.model.RateServiceModel;
import com.applesoft.model.RateServiceResponseModel;
import com.applesoft.translator.RateServiceTranslator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Sipho on 04/09/2017.
 */
@Component
public class RateServiceCore {
  @Autowired
  private RateServiceDAO rateServiceDAO;
  @Autowired
  private RateServiceTranslator rateServiceTranslator;

  /**
   * Save service rate
   * @param branchName
   * @param rateService
   * @return
   */
  public RateServiceModel saveServiceRating(String branchName, String rateService){
    return rateServiceDAO.saveServiceRating(rateServiceTranslator.buildRateServiceModel(branchName, rateService));
  }

  /**
   * Get service rates
   * @param rateService
   * @param startDate
   * @param endDate
   * @return {@Link List<RateServiceResponseModel>}
   */
  public List<RateServiceResponseModel> getServiceRatings(String rateService, String startDate, String endDate){
    return rateServiceDAO.getServiceRatings(rateService, startDate, endDate);
  }
}
