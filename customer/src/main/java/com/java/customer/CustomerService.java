package com.java.customer;

import com.java.clients.fraud.FraudCheckResponse;
import com.java.clients.fraud.FraudClient;
import com.java.clients.notification.NotificationClient;
import com.java.clients.notification.NotificationRequest;
import com.java.customer.exception.ErrorMessage;
import com.java.customer.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final FraudClient fraudClient;

    @Autowired
    private final NotificationClient notificationClient;

    public Customer registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}"
//                , FraudCheckResponse.class, customer.getId());
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        notificationClient.sendNotification(new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                customer.getFirstName())
        );
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalArgumentException("fraudster");
        }

        return customer;
    }


    public Customer findById(Integer sId) throws ErrorMessage {
//        return customerRepository.getReferenceById(sId);
        return customerRepository.findById(sId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer", "id", sId));
    }
}
