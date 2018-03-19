package com.belatrixsf.summary.services.backend;

import com.belatrixsf.summary.model.CustomerInfo;
import java.util.Optional;
import javax.swing.text.html.Option;

public interface CustomerService {

  Optional<CustomerInfo> getCustomerInfo(Integer id);

}
