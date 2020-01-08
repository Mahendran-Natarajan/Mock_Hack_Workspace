package com.hcl.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {

    public static void main(String[] args) {
        String ar[] = {"ab", "abc", "bc", "ab", "ca", "ca"};
        List<String> strList = Arrays.asList(ar);
        HashSet set = new HashSet<String>();
        strList.forEach(s -> {
            if (set.contains(s)) {
                set.remove(s);
            } else {
                set.add(s);
            }
        });
        System.out.println(set);
    }
}


