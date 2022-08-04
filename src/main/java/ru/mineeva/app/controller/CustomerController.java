package ru.mineeva.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mineeva.app.model.CustomerRequest;
import ru.mineeva.app.services.CustomerService;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "imports", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveAllCustomers(@RequestBody CustomerRequest customerRequest) {
        customerService.saveCustomerRequest(customerRequest);
        return ResponseEntity.ok().build();
    }

}
