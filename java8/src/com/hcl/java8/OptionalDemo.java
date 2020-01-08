package com.hcl.java8;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) throws Exception {
        int age = 20;
        System.out.println("Hello WOrld");
        Optional<String> hello = Optional.ofNullable("Hello World");
        System.out.println(hello.get());
        System.out.println(hello.orElse("Empty"));
        hello.orElseThrow(() -> new Exception("Hello world exception"));
        System.out.println(hello.filter( str ->  str.contains("hello")).orElse("Not matched"));

    }
}
