package com.belatrixsf.orders.repositories;

import com.belatrixsf.orders.model.CustomerOrder;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {

  List<CustomerOrder> findAllByCustomerId(Integer customerId);


}
