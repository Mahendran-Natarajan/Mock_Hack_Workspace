package com.hcl.java8;

import java.time.LocalDate;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate beforeDate = LocalDate.of(1983, 05, 01);
        LocalDate afterDate = LocalDate.of(2083, 05, 01);
        System.out.println(date);
        System.out.println(beforeDate);
        System.out.println(afterDate);

        System.out.println(afterDate.isAfter(date));
        System.out.println(beforeDate.isBefore(date));
    }
}
