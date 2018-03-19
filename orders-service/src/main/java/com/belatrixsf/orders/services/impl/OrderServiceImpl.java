package com.belatrixsf.orders.services.impl;

import com.belatrixsf.orders.model.CustomerOrder;
import com.belatrixsf.orders.repositories.CustomerOrderRepository;
import com.belatrixsf.orders.services.OrderService;
import java.util.List;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private CustomerOrderRepository repository;


  @Autowired
  public OrderServiceImpl(CustomerOrderRepository repository) {
    Validate.notNull(repository);
    this.repository = repository;
  }


  @Override
  public List<CustomerOrder> findCustomerOrders(Integer customerId) {
    return repository.findAllByCustomerId(customerId);
  }

}
