package com.belatrixsf.summary.services.impl;

import com.belatrixsf.summary.model.CustomerInfo;
import com.belatrixsf.summary.model.OrderInfo;
import com.belatrixsf.summary.services.backend.CustomerService;
import com.belatrixsf.summary.services.backend.OrderService;
import com.belatrixsf.summary.services.SummaryService;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryServiceImpl implements SummaryService {

  private CustomerService customerService;

  private OrderService orderService;


  @Autowired
  public SummaryServiceImpl(CustomerService customerService, OrderService orderService) {
    Validate.notNull(customerService);
    Validate.notNull(orderService);
    this.customerService = customerService;
    this.orderService = orderService;
  }


  @Override
  public Optional<CustomerInfo> getCustomerSummary(Integer id) {
    Optional<CustomerInfo> rs = customerService.getCustomerInfo(id);
    if (!rs.isPresent()) {
      return null;
    }
    CustomerInfo customer = rs.get();
    List<OrderInfo> orders = orderService.getCustomerOrdersInfo(id);
    if (!orders.isEmpty()) {
      customer.setOrders(orders);
    }
    return Optional.of(customer);
  }

}
