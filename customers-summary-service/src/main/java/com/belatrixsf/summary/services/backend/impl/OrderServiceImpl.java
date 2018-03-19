package com.belatrixsf.summary.services.backend.impl;

import com.belatrixsf.summary.model.OrderInfo;
import com.belatrixsf.summary.services.backend.OrderService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

  private RestTemplate restTemplate;

  @Value("${services.orders.url}")
  private String ordersServiceUrl;


  @Autowired
  public OrderServiceImpl(RestTemplate restTemplate) {
    Validate.notNull(restTemplate);
    this.restTemplate = restTemplate;
  }


  @Override
  public List<OrderInfo> getCustomerOrdersInfo(Integer customerId) {
    ParameterizedTypeReference<List<OrderInfo>> typeRef = new ParameterizedTypeReference<List<OrderInfo>>() {
    };
    ResponseEntity<List<OrderInfo>> rs = restTemplate
        .exchange(ordersServiceUrl + "/customers/{id}/orders",
            HttpMethod.GET,
            null, typeRef, customerId);
    List<OrderInfo> orders = rs.getBody();
    if (orders == null || orders.isEmpty()) {
      return new ArrayList<>();
    }
    return orders;
  }

}
