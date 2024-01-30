package com.java.customer;

import lombok.NonNull;

public record CustomerRegistrationRequest(
        @NonNull
        String firstName,
        @NonNull
        String lastName,
        @NonNull
        String email
) {
}
