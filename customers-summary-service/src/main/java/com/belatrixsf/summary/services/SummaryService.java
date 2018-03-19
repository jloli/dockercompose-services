package com.belatrixsf.summary.services;

import com.belatrixsf.summary.model.CustomerInfo;
import java.util.Optional;

public interface SummaryService {

  public Optional<CustomerInfo> getCustomerSummary(Integer id);

}
