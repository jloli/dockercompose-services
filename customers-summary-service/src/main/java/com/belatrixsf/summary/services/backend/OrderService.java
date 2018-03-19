package com.belatrixsf.summary.services.backend;

import com.belatrixsf.summary.model.OrderInfo;
import java.util.List;

public interface OrderService {

  List<OrderInfo> getCustomerOrdersInfo(Integer customerId);

}
