package com.applesoft.service;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import com.applesoft.dao.RateServiceDAO;
import com.applesoft.model.RateServiceModel;
import com.applesoft.model.RateServiceResponseModel;
import com.applesoft.translator.RateServiceTranslator;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Sipho on 04/09/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RateServiceCoreTest {
  @Mock
  RateServiceTranslator rateServiceTranslator;
  @Mock
  RateServiceDAO rateServiceDAO;
  @Mock
  private RateServiceCore rateServiceCore;

  @Test
  public void saveServiceRatingTest() {
    RateServiceModel rateServiceModel = new RateServiceModel();
    rateServiceModel.setBranchName("Tokai");
    rateServiceModel.setRateService("Happy");
    when(rateServiceTranslator.buildRateServiceModel(anyString(), anyString())).thenReturn(rateServiceModel);
    when(rateServiceDAO.saveServiceRating(rateServiceModel)).thenReturn(rateServiceModel);
    when(rateServiceCore.saveServiceRating(anyString(), anyString())).thenReturn(rateServiceModel);
    Assert.assertEquals("Tokai",rateServiceModel.getBranchName());
  }

  @Test
  public void getServiceRatingsTest() {
    RateServiceResponseModel rateServiceResponseModel = new RateServiceResponseModel();
    rateServiceResponseModel.setTotalHappiness(10L);
    when(rateServiceDAO.getServiceRatings(anyString(), anyString(),anyString())).thenReturn(Arrays.asList(rateServiceResponseModel));
    when(rateServiceCore.getServiceRatings(anyString(), anyString(), anyString())).thenReturn(Arrays.asList(rateServiceResponseModel));
    Assert.assertEquals(10L, Long.valueOf(rateServiceResponseModel.getTotalHappiness()).longValue());
  }
}
