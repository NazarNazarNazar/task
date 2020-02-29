package com.antnzr.func.funcInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "0000099");
        greetCustomer(maria);

        // Functional Interface
        greetCustomerConsumer.accept(maria);
        greetCustomerConsumerV2.accept(maria, false);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.format("Hello %s, thanks for registering phone number: %s \n",
                    customer.customerName, customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.format("Hello %s, thanks for registering phone number: %s \n",
                    customer.customerName, (showPhoneNumber ? customer.customerPhoneNumber : "*********"));

    static void greetCustomer(Customer customer) {
        System.out.println(String.format("Hello %s, thanks for registering phone number: %s\n",
                customer.customerName, customer.customerPhoneNumber));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
