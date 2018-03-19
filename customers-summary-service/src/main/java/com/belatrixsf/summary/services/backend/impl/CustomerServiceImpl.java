package com.belatrixsf.summary.services.backend.impl;

import com.belatrixsf.summary.model.CustomerInfo;
import com.belatrixsf.summary.services.backend.CustomerService;
import java.util.Optional;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceImpl implements CustomerService {

  private RestTemplate restTemplate;


  @Autowired
  public CustomerServiceImpl(RestTemplate restTemplate) {
    Validate.notNull(restTemplate);
    this.restTemplate = restTemplate;
  }


  @Override
  public Optional<CustomerInfo> getCustomerInfo(Integer id) {
    ResponseEntity<CustomerInfo> rs = restTemplate
        .getForEntity("http://localhost:8000/customersService/api/v1/customers/{id}",
            CustomerInfo.class, id);
    if (HttpStatus.OK.equals(rs.getStatusCode())){
      return Optional.of(rs.getBody());
    } else {
      return null;
    }
  }

}
