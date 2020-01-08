package com.hcl.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) throws IOException {

        Stream<String> streamStr = Files.lines(Paths.get("\\mahendran\\workspace\\java8\\test_sample.txt"));
       // streamStr.findFirst().ifPresent(System.out::println);

        List<String> filterResults = streamStr
                //.filter(s -> s.length() >= 2 && s.length() <= 3)
                .filter(s -> s.length() >= 2)
                .filter(s ->  s.length() <= 3)
                //.filter(s -> s.length() < 3)
                .collect(Collectors.toList());
        filterResults.forEach(System.out::println);
    }
}
