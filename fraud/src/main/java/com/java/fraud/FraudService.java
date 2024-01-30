package com.java.fraud;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class FraudService {
    private final FraudRepository fraudRepository;

    public boolean isFraudlentCustomer(Integer customerId) {
        fraudRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now()).build()
        );
        log.info("fraud check request for customer {}",customerId);

        return false;
    }
}
