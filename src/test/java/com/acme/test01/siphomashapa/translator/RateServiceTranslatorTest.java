package com.acme.test01.siphomashapa.translator;

import org.junit.Ignore;
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
  private ACMEBankTranslator ACMEBankTranslator;
  @Ignore @Test
  public void buildRateServiceModelTest() {
    //ACMERequestModel ACMERequestModel = ACMEBankTranslator.buildRateServiceModel("Tokai", "Happy");
    /*Assert.assertEquals("Tokai", ACMERequestModel.getBranchName());*/
  }
}
