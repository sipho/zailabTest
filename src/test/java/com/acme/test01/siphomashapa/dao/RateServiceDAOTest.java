package com.acme.test01.siphomashapa.dao;

import org.junit.Ignore;
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
public class RateServiceDAOTest {
  @Mock
  ACMEBankDAO ACMEBankDAO;
  @Ignore @Test
  public void getRatings() {
    //when(ACMEBankDAO.getServiceRatings(any(String.class), any(String.class), any(String.class))).thenReturn(new ArrayList<RateServiceResponseModel>());

  }
}
