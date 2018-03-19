package com.belatrixsf.customers.services;

import com.belatrixsf.customers.model.Customer;
import java.util.Optional;

public interface CustomerService {

  Optional<Customer> getCustomer(Integer id);

}
