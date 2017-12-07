package com.lance.demo.guava.util;

import com.google.common.base.Joiner;

import java.util.List;
import java.util.Map;

public class JoinerDemo {


    void joinNoneNull(List<String> noneNullList) {
        System.out.println(Joiner.on("$").join(noneNullList));
    }

    void joinNull(List<String> nullList) {
        System.out.println(Joiner.on("$").skipNulls().join(nullList));
    }

    void joinDefault(List<String> nullList) {
        System.out.println(Joiner.on("$").useForNull("null").join(nullList));
    }

    void append(List<String> nullList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = Joiner.on("$").useForNull("null").appendTo(stringBuilder, nullList);
        System.out.println(stringBuilder.toString());
    }

    void map(Map<String, Integer> map) {
        System.out.println(Joiner.on("$").useForNull("nop").withKeyValueSeparator("=").join(map));
    }
}