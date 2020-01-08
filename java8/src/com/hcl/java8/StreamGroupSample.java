package com.hcl.java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamGroupSample {

    List<Apple> appleList = new ArrayList<>();

    public void addApples() {
        appleList.add(new Apple("Red", 150.0));
        appleList.add(new Apple("Green", 150.0));
        appleList.add(new Apple("Yellow", 150.0));

        appleList.add(new Apple("Red", 160.0));
        appleList.add(new Apple("Green", 160.0));
        appleList.add(new Apple("Yellow", 160.0));

        appleList.add(new Apple("Red", 170.0));
        appleList.add(new Apple("Green", 170.0));
        appleList.add(new Apple("Yellow", 170.0));

        appleList.add(new Apple("Green", 150.0));
        appleList.add(new Apple("Red", 170.0));
        appleList.add(new Apple("Yellow", 160.0));

    }

    public static void main(String[] args) {
        StreamGroupSample sample = new StreamGroupSample();
        sample.addApples();
        Integer size = sample.appleList.size();
     //   Set<Apple> collectSet = sample.appleList.stream().collect(Collectors.toSet());
        Map<String, Integer> collectMap = sample.appleList.stream().collect(Collectors.groupingBy(Apple::getColor,
                Collectors.collectingAndThen(Collectors.mapping(Apple::getColor, Collectors.toList()), List::size)));

       // System.out.println(collectSet);
        System.out.println(collectMap);


        Map<Double, Integer> collect = sample.appleList.stream().collect(Collectors.groupingBy(Apple::getWeight,
                Collectors.collectingAndThen(
                Collectors.mapping(Apple::getWeight, Collectors.toSet()), Set::size)));
        System.out.println(collect);


        Integer collect1 = sample.appleList.stream().collect(Collectors.collectingAndThen(Collectors.mapping(Apple::getColor,
                Collectors.toSet()), Set::size));
        System.out.println(collect1);


        Map<String, Map<Double, List<Apple>>> collect2 = sample.appleList.stream().collect(Collectors.groupingBy(Apple::getColor,
                Collectors.groupingBy(Apple::getWeight)));
        System.out.println(collect2);

        Map<String, Double> collect3 = sample.appleList.stream().collect(
                Collectors.groupingBy(Apple::getColor,
                        Collectors.averagingDouble(Apple::getWeight)));
        System.out.println(collect3);

        Map<String, Double> collect4 = sample.appleList.stream().collect(
                Collectors.groupingBy(Apple::getColor,
                        Collectors.summingDouble(Apple::getWeight)));
        System.out.println(collect4);

        Map<String, DoubleSummaryStatistics> collect5 = sample.appleList.stream().collect(
                Collectors.groupingBy(Apple::getColor,
                        Collectors.summarizingDouble(Apple::getWeight)));
        System.out.println(collect5);

        Map<String, String> collect6 = sample.appleList.stream().collect(
                Collectors.groupingBy(Apple::getColor, Collectors.mapping(Apple::getColor,
                        Collectors.joining(":", "Colors[", "]"))));

        System.out.println(collect6);

    }
}
