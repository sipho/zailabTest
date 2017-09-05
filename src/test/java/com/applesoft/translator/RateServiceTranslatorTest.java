package com.applesoft.translator;

import com.applesoft.model.RateServiceModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Sipho on 04/09/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RateServiceTranslatorTest {
  @InjectMocks
  private RateServiceTranslator rateServiceTranslator;
  @Test
  public void buildRateServiceModelTest() {
    RateServiceModel rateServiceModel = rateServiceTranslator.buildRateServiceModel("Tokai", "Happy");
    Assert.assertEquals("Tokai",rateServiceModel.getBranchName());
  }
}
