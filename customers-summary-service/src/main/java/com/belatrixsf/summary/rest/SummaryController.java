package com.belatrixsf.summary.rest;

import com.belatrixsf.summary.model.CustomerInfo;
import com.belatrixsf.summary.services.SummaryService;
import java.util.Optional;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummaryController {

  private SummaryService service;

  @Autowired
  public SummaryController(SummaryService service) {
    Validate.notNull(service);
    this.service = service;
  }

  @GetMapping("/customers/{id}/summary")
  public ResponseEntity<CustomerInfo> getCustomerSummary(@PathVariable Integer id) {
    Optional<CustomerInfo> c = service.getCustomerSummary(id);
    if (c.isPresent()) {
      return new ResponseEntity<CustomerInfo>(c.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<CustomerInfo>(HttpStatus.NOT_FOUND);
    }
  }


}
