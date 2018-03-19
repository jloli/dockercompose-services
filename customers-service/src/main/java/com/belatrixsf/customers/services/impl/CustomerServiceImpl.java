package com.belatrixsf.customers.services.impl;

import com.belatrixsf.customers.model.Customer;
import com.belatrixsf.customers.repositories.CustomerRepository;
import com.belatrixsf.customers.services.CustomerService;
import java.util.Optional;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository repository;


  @Autowired
  public CustomerServiceImpl(CustomerRepository repository) {
    Validate.notNull(repository);
    this.repository = repository;
  }


  @Override
  public Optional<Customer> getCustomer(Integer id) {
    return repository.findById(id);
  }

}
