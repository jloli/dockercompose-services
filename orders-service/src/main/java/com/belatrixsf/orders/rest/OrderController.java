package com.belatrixsf.orders.rest;

import com.belatrixsf.orders.model.CustomerOrder;
import com.belatrixsf.orders.services.OrderService;
import java.util.List;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  private OrderService service;


  @Autowired
  public OrderController(OrderService service) {
    Validate.notNull(service);
    this.service = service;
  }

  @GetMapping("/customers/{customerId}/orders")
  public List<CustomerOrder> getCustomerOrders(@PathVariable Integer customerId) {
    return service.findCustomerOrders(customerId);
  }

}
