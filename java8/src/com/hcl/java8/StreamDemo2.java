package com.hcl.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) throws IOException {

        Stream<String> streamStr = Files.lines(Paths.get("\\mahendran\\workspace\\java8\\test_sample_salary.txt"));

        Optional<Integer> first = streamStr
                .map(Integer::new)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        first.ifPresent(System.out::println);
    }
}
