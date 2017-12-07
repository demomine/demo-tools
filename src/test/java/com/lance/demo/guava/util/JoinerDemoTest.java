package com.lance.demo.guava.util;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JoinerDemoTest {
    private final List<String> noneNullList = Arrays.asList("name", "age", "id");
    private final List<String> nullList = Arrays.asList("name", "age", null);
    private final Map<String, Integer> map = Maps.newHashMap();
    private JoinerDemo joinerDemo = new JoinerDemo();
    @Test
    public void joinNoneNull() throws Exception {
        joinerDemo.joinNoneNull(noneNullList);
    }

    @Test
    public void joinNull() throws Exception {
        joinerDemo.joinNull(nullList);
    }

    @Test
    public void joinDefault() throws Exception {
        joinerDemo.joinDefault(nullList);
    }

    @Test
    public void joinAppend() throws Exception {
        joinerDemo.append(nullList);
    }

    @Test
    public void joinMap() throws Exception {
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put(null, 4);
        joinerDemo.map(map);
    }
}