package com.java.customer;

import com.java.customer.exception.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) throws ErrorMessage {
        log.info("new customer registration {}" + customerRegistrationRequest);
        return new ResponseEntity<Customer>(customerService.registerCustomer(customerRegistrationRequest), HttpStatus.CREATED);
    }

    @RequestMapping(path = "findById/{sId}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Customer> findById(@PathVariable Integer sId) throws ErrorMessage {
        System.out.println(sId);

//        Optional<Customer> customer = Optional.of(customerService.findById(sId));
//        log.info("customer data  : " + customer);
//
//        if (customer.isEmpty()) {
//            throw new ErrorMessage("Customer contain Don't have any data ");
//        } else {
        return ResponseEntity.ok(customerService.findById(sId));

//        }
    }


}
