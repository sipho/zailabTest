package com.applesoft.translator;

import com.applesoft.model.RateServiceModel;
import com.applesoft.util.DateConverters;
import org.springframework.stereotype.Component;

/**
 * Created by Sipho on 04/09/2017.
 */
@Component
public class RateServiceTranslator {
  public RateServiceModel buildRateServiceModel(String branchName, String rateService){
    RateServiceModel rateServiceModel = new RateServiceModel();
    rateServiceModel.setBranchName(branchName);
    rateServiceModel.setRateService(rateService);
    rateServiceModel.setDate(DateConverters.createDate());
    return rateServiceModel;
  }
}
