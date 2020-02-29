package com.antnzr.func.funcInterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        String phoneNumber = "07777788888";
        String phoneNumber1 = "09777788888";
        String phoneNumber2 = "07737788888";

        System.out.println("Legacy");
        System.out.println(isPhoneNumberValid(phoneNumber));
        System.out.println(isPhoneNumberValid(phoneNumber1));

        System.out.println("\nPredicate");
        System.out.println(isPhoneNumberValidPredicate.test(phoneNumber));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber).test(phoneNumber2));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber = phoneNumber ->
            phoneNumber.contains("3");
}
