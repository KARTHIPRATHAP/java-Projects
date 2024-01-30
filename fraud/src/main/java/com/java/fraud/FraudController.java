package com.java.fraud;

import com.java.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check/")
@AllArgsConstructor
public class FraudController {
    private final FraudService fraudHistoryService;


    @GetMapping(path = {"{customerId}"})
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudlentCustomer = fraudHistoryService.isFraudlentCustomer(customerId);
        return new FraudCheckResponse(isFraudlentCustomer);
    }
}
