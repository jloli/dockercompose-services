package com.belatrixsf.orders.services;

import com.belatrixsf.orders.model.CustomerOrder;
import java.util.List;

public interface OrderService {

  List<CustomerOrder> findCustomerOrders(Integer customerId);

}
