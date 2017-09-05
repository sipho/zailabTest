package com.applesoft.dao;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.applesoft.model.RateServiceResponseModel;
import java.util.ArrayList;
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
  RateServiceDAO rateServiceDAO;
  @Test
  public void getRatings() {
    when(rateServiceDAO.getServiceRatings(any(String.class), any(String.class), any(String.class))).thenReturn(new ArrayList<RateServiceResponseModel>());

  }
}
