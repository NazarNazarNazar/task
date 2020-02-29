package com.antnzr.func.combinatorpattern;

import java.time.LocalDate;

import static com.antnzr.func.combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+080088374388",
                LocalDate.of(2000, 1, 1)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
