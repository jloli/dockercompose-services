package com.belatrixsf.summary.services.backend.impl;

import com.belatrixsf.summary.model.CustomerInfo;
import com.belatrixsf.summary.services.backend.CustomerService;
import java.util.Optional;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceImpl implements CustomerService {

  private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);


  private RestTemplate restTemplate;

  @Value("${services.customers.url}")
  private String customerServiceUrl;


  @Autowired
  public CustomerServiceImpl(RestTemplate restTemplate) {
    Validate.notNull(restTemplate);
    this.restTemplate = restTemplate;
  }


  @Override
  public Optional<CustomerInfo> getCustomerInfo(Integer id) {

    LOG.debug("Customer service URL: " + customerServiceUrl);

    ResponseEntity<CustomerInfo> rs = restTemplate
        .getForEntity(customerServiceUrl + "/customers/{id}",
            CustomerInfo.class, id);
    if (HttpStatus.OK.equals(rs.getStatusCode())) {
      return Optional.of(rs.getBody());
    } else {
      return null;
    }
  }

}
