package com.belatrixsf.summary.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.apache.commons.lang3.Validate;

public class CustomerInfo {

  private final Integer id;

  private final String firstName;

  private final String lastName;

  private final String email;

  private List<OrderInfo> orders;


  @JsonCreator
  public CustomerInfo(@JsonProperty("id") Integer id, @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName, @JsonProperty("email") String email) {

    Validate.notNull(id);
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }


  public Integer getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  @JsonProperty("orders")
  public List<OrderInfo> getOrders() {
    return orders;
  }

  public void setOrders(List<OrderInfo> orders) {
    this.orders = orders;
  }

}
