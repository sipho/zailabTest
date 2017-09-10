package com.acme.test01.siphomashapa.translator;

import com.acme.test01.siphomashapa.model.ACMERequestModel;
import org.springframework.stereotype.Component;

/**
 * Created by Sipho on 10/09/2017.
 */
@Component
public class ACMEBankTranslator {
  public ACMERequestModel buildACMERequestModel(long accountId, long amountToDeposit, String accountType, int id){
    ACMERequestModel acmeRequestModel = new ACMERequestModel();
    acmeRequestModel.setAccountId(String.valueOf(accountId));
    acmeRequestModel.setBalance(String.valueOf(amountToDeposit));
    acmeRequestModel.setAccountType(accountType);
    if (id != 000)
    acmeRequestModel.setId(id);

    return acmeRequestModel;
  }
}
