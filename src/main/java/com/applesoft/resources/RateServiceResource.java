package com.applesoft.resources;

import com.applesoft.model.RateServiceModel;
import com.applesoft.model.RateServiceResponseModel;
import com.applesoft.service.RateServiceCore;
import io.swagger.annotations.ApiParam;
import java.awt.Toolkit;
import java.util.List;
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
 * Created by Sipho on 04/09/2017.
 */
@Path("v1/{branchName}")
@RestController
public class RateServiceResource {
  private static final Logger logger = LoggerFactory.getLogger(RateServiceResource.class);
  @Autowired
  private RateServiceCore rateServiceCore;

  /**
   * Save Rate
   * @param branchName
   * @param rateService its value can be Happy, Bad etc
   * @return {@Link Response}
   */

  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  @RequestMapping(method = RequestMethod.POST, value = "/applesoft/v1/{branchName}",
      produces = MediaType.APPLICATION_JSON)
  public RateServiceModel saveServiceRate(@ApiParam(value = "Store branch name") @PathParam("branchName") @PathVariable(name = "branchName") String branchName,
      @ApiParam(value = "Value for rateService can be Happy, Bad etc") @QueryParam("rateService") @RequestParam(name = "rateService", required = true) String rateService) {
    logger.info("POST Request, branchName: " + branchName + ", rateService: " + rateService);
    Toolkit.getDefaultToolkit().beep();
    return rateServiceCore.saveServiceRating(branchName, rateService);
  }

  /**
   * Get number of service rates
   * @param branchName
   * @param rateService its value can be Happy, Bad etc
   * @param startDate
   * @param endDate
   * @return {@Link List<RateServiceResponseModel>}
   */
  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  @RequestMapping(method = RequestMethod.GET, value = "/applesoft/v1/{branchName}",
      produces = MediaType.APPLICATION_JSON)
  public List<RateServiceResponseModel> getNumberOfServiceRates(@ApiParam(value = "Store branch name") @PathParam("branchName") @PathVariable(name = "branchName") String branchName,
      @ApiParam(value = "Value for rateService can be Happy, Bad etc") @QueryParam("rateService") @RequestParam(name = "rateService", required = true) String rateService,
      @QueryParam("startDate") @RequestParam(name = "startDate", required = false) String startDate,
      @QueryParam("endDate") @RequestParam(name = "endDate", required = false) String endDate) {
    logger.debug("GET Request, branchName: " + branchName + ", rateService: " + rateService);
    return rateServiceCore.getServiceRatings(rateService, startDate, endDate);
  }

}
