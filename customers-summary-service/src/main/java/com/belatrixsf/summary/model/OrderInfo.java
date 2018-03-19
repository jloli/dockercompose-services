package com.belatrixsf.summary.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.Validate;

public class OrderInfo {

  private final Long id;

  private final String description;

  private final Date orderDate;

  private final BigDecimal totalAmount;


  @JsonCreator
  public OrderInfo(@JsonProperty("id") Long id, @JsonProperty("description") String description,
      @JsonProperty("orderDate") Date orderDate,
      @JsonProperty("totalAmount") BigDecimal totalAmount) {

    Validate.notNull(id);
    this.id = id;
    this.description = description;
    this.orderDate = orderDate;
    this.totalAmount = totalAmount;
  }


  public Long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public Date getOrderDate() {
    return orderDate != null ? new Date(orderDate.getTime()) : null;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

}
