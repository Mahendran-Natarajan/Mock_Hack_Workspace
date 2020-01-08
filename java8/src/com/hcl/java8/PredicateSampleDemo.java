package com.hcl.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateSampleDemo {


    public static Predicate<Apple> isWeightAbove150() {
        return apple -> apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        return apples.stream().filter(predicate).sorted(Comparator.comparing(Apple::getColor))
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("Green", 165.0), new Apple("Zellow", 350.0),
                new Apple("Simla", 30.0),new Apple("Red", 250.0));
        List<Apple> apples1 = filterApples(apples, isWeightAbove150());
        apples1.forEach(System.out::println);
    }
}
